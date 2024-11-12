package com.example.rizqi_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.*
import com.example.rizqi_project.data.DataProvider
import com.example.rizqi_project.data.Food
import com.example.rizqi_project.data.NavItem
import com.example.rizqi_project.pages.AboutPage
import com.example.rizqi_project.pages.ListPage
import com.example.rizqi_project.pages.DetailPage
import com.example.rizqi_project.ui.theme.Rizqi_ProjectTheme

class MainScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Rizqi_ProjectTheme {
                MainScreen(
                    navigateToProfile = { food: Food ->
                        println("Navigating to profile of ${food.category}")
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, navigateToProfile: (Food) -> Unit) {
    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("List", Icons.Default.Menu, 0),
        NavItem("About", Icons.Default.Person, 0)
    )

    var selectedIndex by remember { mutableStateOf(0) }
    val navController = rememberNavController()
    val barColor = Color(0xFFD0DD97)
    var searchQuery by remember { mutableStateOf("") }
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute != null && !currentRoute.startsWith("detail/")) {
                Column {
                    TopAppBar(
                        title = {
                            Text(text = navItemList[selectedIndex].label)
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = barColor,
                            titleContentColor = Color.Black
                        )
                    )
                    if (currentRoute == "home" || currentRoute == "list") {
                        SearchBar(
                            query = searchQuery,
                            onQueryChange = { searchQuery = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
            }
        },
        bottomBar = {
            if (currentRoute != null && !currentRoute.startsWith("detail/")) {
                NavigationBar(
                    containerColor = barColor
                ) {
                    navItemList.forEachIndexed { index, navItem ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index
                                when (index) {
                                    0 -> navController.navigate("home")
                                    1 -> navController.navigate("list")
                                    2 -> navController.navigate("about")
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = "Icon",
                                    tint = if (selectedIndex == index) Color.White else Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            label = { Text(text = navItem.label) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = Color.Black,
                                selectedIconColor = Color.Black,
                                unselectedTextColor = Color.Black,
                                unselectedIconColor = Color.Black
                            )
                        )
                    }
                }
            }
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = modifier.padding(innerPadding)
            ) {
                composable("home") {
                    HomePage(
                        modifier = modifier,
                        searchQuery = searchQuery,
                        navigateToProfile = { food ->
                            navController.navigate("detail/${food.id}")
                        }
                    )
                }
                composable("list") {
                    ListPage(
                        modifier = modifier,
                        searchQuery = searchQuery,
                        navigateToProfile = { food ->
                            navController.navigate("detail/${food.id}")
                        }
                    )
                }
                composable("about") {
                    AboutPage(modifier = modifier)
                }
                composable("detail/{foodId}") { backStackEntry ->
                    val foodId = backStackEntry.arguments?.getString("foodId")
                    val food = DataProvider.foodList.first { it.id.toString() == foodId }
                    DetailPage(food = food, navController = navController)
                }
            }
        }
    )
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(
                text = "Search...",
                style = TextStyle(fontSize = 14.sp, color = Color(0xFFB2B2B2))
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color(0xFFB2B2B2),
                modifier = Modifier.size(20.dp)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = Color(0xFF888888)
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = Color(0xFF888888)
        )
    )
}

@Composable
fun HomePage(modifier: Modifier = Modifier, searchQuery: String, navigateToProfile: (Food) -> Unit) {
    val filteredFoodList = DataProvider.foodList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFBFBFB))
        ) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(filteredFoodList.take(10)) { food ->
                    FoodListItemForHomePage(food = food, navigateToProfile = navigateToProfile)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFBFBFB))
        ) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(filteredFoodList.take(10)) { food ->
                    FoodListItemForHomePage(food = food, navigateToProfile = navigateToProfile)
                }
            }
        }
    }
}

@Composable
fun ListPage(modifier: Modifier = Modifier, searchQuery: String, navigateToProfile: (Food) -> Unit) {
    val filteredFoodList = DataProvider.foodList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFBFBFB))
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredFoodList.take(10)) { food ->
                FoodListItemForListPage(
                    food = food,
                    navigateToProfile = navigateToProfile  
                )
            }
        }
    }
}