package com.packt.chapterseven.views

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.packt.chapterseven.navigation.Screens

@Composable
fun PetsNavigationRail(
    onFavoriteClicked: () -> Unit,
    onHomeClicked: () -> Unit,
    onDrawerClicked: () -> Unit
) {
    val items = listOf(Screens.CityListScreen, Screens.FavoritePetsScreen)
    val selectedItem = remember { mutableStateOf(items[0]) }

    NavigationRail(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        NavigationRailItem(
            selected = false,
            onClick = onDrawerClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon"
                )
            }
        )

        NavigationRailItem(
            selected = selectedItem.value == Screens.CityListScreen,
            onClick = {
                onHomeClicked()
                selectedItem.value = Screens.CityListScreen
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            }
        )

        NavigationRailItem(
            selected = selectedItem.value == Screens.FavoritePetsScreen,
            onClick = {
                onFavoriteClicked()
                selectedItem.value = Screens.FavoritePetsScreen
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon"
                )
            }
        )
    }
}