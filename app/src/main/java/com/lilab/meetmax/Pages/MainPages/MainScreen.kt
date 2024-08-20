package com.lilab.meetmax.Pages.MainPages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lilab.meetmax.Pages.AuthPages.LoginPage
import com.lilab.meetmax.Pages.Navigation.NavItem
import com.lilab.meetmax.R
import com.lilab.meetmax.ViewModel.PostViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, navHostController: NavHostController,postViewModel: PostViewModel) {
    val navItems = listOf(
        NavItem("Feed", R.drawable.feed,0),
        NavItem("Community", R.drawable.community,0),
        NavItem("Explore", R.drawable.explore,0),
        NavItem("Notification", R.drawable.notification,2),
        NavItem("Settings", R.drawable.setting,0),

    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar{
                navItems.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            BadgedBox(

                                badge = {

                                    if (navItem.badgeCount > 0) {
                                        Badge(
                                            modifier = Modifier.size(20.dp)
                                                .offset(x = 4.dp, y = (-4).dp),
                                            containerColor = Color.Red
                                        ) {
                                            Text(
                                                text = navItem.badgeCount.toString(),
                                                color = Color.White,
                                                fontSize = 9.sp,
                                            )
                                        }
                                    }

                                }

                            ) {
                                Icon(
                                    painter = painterResource(id = navItem.icon),
                                    contentDescription = navItem.label,
                                    modifier = Modifier.size(21.dp)
                                )
                            }

                        },
                        label = { Text(
                            navItem.label,
                            fontFamily =  FontFamily(Font(R.font.rmedium, FontWeight.Medium)),
                            fontSize = 10.sp

                        )
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex, navHostController = navHostController, postViewModel = postViewModel)
    }

}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex : Int, navHostController: NavHostController, postViewModel: PostViewModel) {
    when (selectedIndex) {
       0 -> HomePage(navHostController= navHostController, postViewModel = postViewModel)
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

  //  MainScreen()
}