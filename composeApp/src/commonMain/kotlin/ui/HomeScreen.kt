package ui
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import models.ApiResponse
import models.Products
import network.ApiStatus
import network.NetWorkResult
import org.koin.compose.getKoin
import viewmodel.HomeViewModel

@Composable
fun HomeScreen(){

    val viewModel: HomeViewModel= getKoin().get()
    val homeScreenState by viewModel.homeScreenState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getProducts()
    }
    when (homeScreenState) {
        is HomeViewModel.HomeScreenState.Loading -> {
            PiProgressIndicator()
        }
        is HomeViewModel.HomeScreenState.Success -> {
            val products = (homeScreenState as HomeViewModel.HomeScreenState.Success).responseData.list
            ListScreen(products)
        }
        is HomeViewModel.HomeScreenState.Error -> {

        }
    }
}

