package com.example.nativeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PhotoView() {

    val PhotoHandling = viewModel<PhotoViewModel>(LocalContext.current as ViewModelStoreOwner)

/*    val photoIds = arrayOf(
        R.drawable.forest,
        R.drawable.city,
        R.drawable.mountain,
        R.drawable.sea,
        R.drawable.sky
    )

    val photonames = arrayOf(
        "Forest",
        "City",
        "Mountain",
        "Sea",
        "Sky"
    )*/

    // val photoitems = List<PhotoItem>(5){PhotoItem()}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xfffacca2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BigPhoto(photoId = PhotoHandling.OpenPhoto.value)
        PhotoButtons(PhotoHandling)
    }
}

@Composable
fun BigPhoto(photoId: Int) {
    Image(painter = painterResource(id = photoId),
        contentDescription = "",
        modifier = Modifier.size(300.dp)
    )
}

@Composable
fun PhotoButtons(photoVM: PhotoViewModel ) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.height(400.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp)
        ) {
            PhotoButton(photoname = "Forest", photoid = R.drawable.forest, photoVM)
            PhotoButton(photoname = "City", photoid = R.drawable.city, photoVM)
            PhotoButton(photoname = "Mountain", photoid = R.drawable.mountain, photoVM)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp)
        ) {
            PhotoButton(photoname = "Sea", photoid = R.drawable.sea, photoVM)
            PhotoButton(photoname = "Sky", photoid = R.drawable.sky, photoVM)
            PhotoButton(photoname = "Rainbow", photoid = R.drawable.rainbow, photoVM)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            PhotoButton(photoname = "Field", photoid = R.drawable.field, photoVM)
            PhotoButton(photoname = "Glacier", photoid = R.drawable.glacier, photoVM)
            PhotoButton(photoname = "Stars", photoid = R.drawable.stars, photoVM)
        }
    }
}

@Composable
fun PhotoButton(photoname: String, photoid: Int, photoVM: PhotoViewModel) {
    Button(onClick = { photoVM.OpenPhoto.value = photoid },
        modifier = Modifier
            .width(100.dp)
            .height(50.dp)
    ) {
        Text(text = photoname)
    }
}