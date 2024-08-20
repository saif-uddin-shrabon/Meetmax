package com.lilab.meetmax.Pages.AppComponent

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.lilab.meetmax.Pages.AdaptiveScreen.WindowType
import com.lilab.meetmax.Pages.AdaptiveScreen.rememberAdaptiveScreenSize
import com.lilab.meetmax.R
import com.lilab.meetmax.ui.theme.LightColorScheme


@Composable
fun EventSection(title: String, content: String) {

    val windowSize = rememberAdaptiveScreenSize()
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {



            when(windowSize.width){
                WindowType.Compact -> {
                    EventHeader()
                    CustomDevider()
                    EventPostContetnt(title,content)
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomDevider()
                    EventReactionsSection()


                }
                else -> {
                    EventHeader()
                    CustomDevider()
                    EventPostContetnt(title,content)
                    CustomDevider()
                    EventReactionsSection()
                }
            }




        }

    }
}

@Composable
fun EventHeader() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ){

      
            Text(
                text = stringResource(id = R.string.eventheading),
                fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
                fontSize = 16.sp,
                color = LightColorScheme.tertiary
            )


        Spacer(modifier = Modifier.weight(1f))


        Icon(painter = painterResource(id = R.drawable.threedot),
            contentDescription = "More Option")


    }
}

@Composable
fun EventPostContetnt(title: String, content: String) {

    Spacer(modifier = Modifier.height(4.dp))


  Row(
      modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
  ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Event Image",
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(8.dp))
        )
      Spacer(modifier = Modifier.width(8.dp))
      Column(
          horizontalAlignment = Alignment.Start,
      ) {
          Text(
              text = title,
              //text = content,
              fontFamily = FontFamily(Font(R.font.rbold, FontWeight.Bold)),
              fontSize = 14.sp,
              color = LightColorScheme.tertiary
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
              text = content,
              //text = content,
              fontFamily = FontFamily(Font(R.font.robotoregular, FontWeight.Normal)),
              fontSize = 12.sp,
              color = LightColorScheme.tertiary
          )
      }
  }
}

@Composable
fun EventReactionsSection() {
    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {





        Text(
            text = "8 seen",
            fontFamily = FontFamily(Font(R.font.rmedium, FontWeight.Normal)),
            fontSize = 12.sp,
            color = LightColorScheme.tertiary
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(modifier = Modifier.width(75.dp)){
            Row(

                verticalAlignment =  Alignment.CenterVertically,
            ){

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Reaction 1",
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Reaction 2",
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Reaction 3",
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )

            }

            //CircleBox
            Box(modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterEnd)
                .background(Color.Gray, CircleShape),
                contentAlignment = Alignment.Center,

                ){
                Text(
                    text = "+8",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }





    }
}

@Preview(showBackground = true, heightDp = 640, widthDp = 340)
@Composable
fun EvenPreview() {
    EventSection( title = "Graduation Ceremony",
        content = "If you think adventure is dangerous, try routine, it’s lethal Paulo Coelho! Good morning all friends.")
   //EventHeader()
   // EventPostContetnt()

  //  EventReactionsSection()

}