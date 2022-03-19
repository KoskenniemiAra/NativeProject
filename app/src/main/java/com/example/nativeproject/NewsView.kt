package com.example.nativeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NewsMain() {

    val newsHandling = viewModel<NewsViewModel>(LocalContext.current as ViewModelStoreOwner)

    Column(modifier = Modifier
        .background(color = Color(0xfffacca2))
        .fillMaxSize()
    ) {
        AddNews( newsHandling )
        newsHandling.news.forEach{
            SingleNews(title = it.title, summary = it.summary)
        }
        SingleNews("Example news", "Example of how a news looks like")
        Divider(
            thickness = 3.dp,
            color = Color.Black)
    }
}

@Composable
fun AddNews( newsVM : NewsViewModel ) {
    var title by remember { mutableStateOf("") }
    var summary by remember { mutableStateOf("") }
    var contents by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = title, onValueChange = {title = it}, label = { Text(text = "Title")}, modifier = Modifier.height(60.dp) )
        OutlinedTextField(value = summary, onValueChange = {summary = it}, label = { Text(text = "Summary")}, modifier = Modifier.height(60.dp) )
        OutlinedTextField(value = contents, onValueChange = {contents = it}, label = { Text(text = "Contents")}, modifier = Modifier.height(60.dp) )
        OutlinedButton(onClick = { newsVM.addnews(title, summary, contents) }, modifier = Modifier.padding(top=5.dp, bottom = 5.dp)) {
            Text(text = "Submit")
        }
    }

}

@Composable
fun SingleNews(title: String, summary: String) {
    Divider(
        thickness = 3.dp,
        color = Color.Black,
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xfffacca2)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding( top = 5.dp)
            )
            Text(
                text = summary,
                color = Color.Gray,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 5.dp)
            )
        }
        Icon(painter = painterResource(id = R.drawable.ic_baseline_image_24), contentDescription = "placeholder")
    }
}