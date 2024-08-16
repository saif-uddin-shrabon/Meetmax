package com.lilab.meetmax.Pages.MainPages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.lilab.meetmax.Pages.AuthPages.LoginPage
import com.lilab.meetmax.Pages.Navigation.NavItem
import com.lilab.meetmax.R

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navItems = listOf(
        NavItem("Feed", R.drawable.feed),
        NavItem("My Community", R.drawable.community),
        NavItem("Explore", R.drawable.explore),
        NavItem("Notification", R.drawable.notification),
        NavItem("Settings", R.drawable.setting),

    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            Icon(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = navItem.label
                            )
                        },
                        label = { Text(navItem.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex : Int) {
    when (selectedIndex) {
        0 -> HomePage()
        1 -> MyCommunity()
        2 -> Explore()
        3 -> Notifications()
        4 -> Settings()
    }
}

//@PreviewScreenSizes
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun LoginPagePreview() {
    MainScreen()
}