package com.edwardcheng.littlelemon.presentation.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.edwardcheng.littlelemon.R
import com.edwardcheng.littlelemon.presentation.components.InfoItem
import com.edwardcheng.littlelemon.presentation.components.LemonButton
import com.edwardcheng.littlelemon.presentation.components.LogoTopBar
import com.edwardcheng.littlelemon.presentation.theme.LittleLemonTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel(),
    onLogoutClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    val viewState: ProfileUiState = viewModel.uiState.collectAsStateWithLifecycle().value
    val viewAction: (ProfileUiAction) -> Unit = { viewModel.handleViewAction(it) }

    ProfileScreenContent(viewState, viewAction)
    ProfileScreenEffect(viewState, onLogoutClick, onBackClick)
}

@Composable
fun ProfileScreenContent(viewState: ProfileUiState, viewAction: (ProfileUiAction) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
//            modifier = Modifier.background(color = MaterialTheme.colorScheme.secondary)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                ) {
                Box(modifier = Modifier.fillMaxWidth()

                ) {
                    IconButton(onClick = { viewAction(ProfileUiAction.ClickBackButton) }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = MaterialTheme.colorScheme.surfaceTint,
                            contentDescription = "Back button",
                        )
                    }
                    LogoTopBar()
                }

            }
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = dimensionResource(id = R.dimen.spacing_large)),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    modifier = Modifier
//                        .padding(dimensionResource(id = R.dimen.spacing_small))
//                        .size(size = 160.dp)
//                        .clip(CircleShape),
//                    painter = painterResource(R.drawable.ic_little_lemon_profile),
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Your profile picture"
//                )
//            }
        }
        Column(verticalArrangement = Arrangement.Top){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top

            ) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
                Text(
                    text = "Personal Information",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                );
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))
            }
            viewState.userInfoList.forEach { profileInfo ->
                InfoItem(info = profileInfo)
            }
        }
        LemonButton(
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.spacing_small))
                .padding(bottom = dimensionResource(id = R.dimen.spacing_large))
                .height(height = dimensionResource(id = R.dimen.spacing_xx_large))
                .fillMaxWidth(),
            text = "Log out",
            onClick = {
                viewAction(ProfileUiAction.ClickLogoutButton)
            }
        )
    }
}

@Composable
fun ProfileScreenEffect(
    viewState: ProfileUiState,
    onLogoutClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    viewState.profileEvent?.let { event ->
        LaunchedEffect(event) {
            when (event) {
                is ProfileVMEvent.NavigateBack -> onBackClick()
                is ProfileVMEvent.NavigateToLogin -> onLogoutClick()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    LittleLemonTheme {
        ProfileScreenContent(
            viewState = ProfileUiState(),
            viewAction = {}
        )
    }
}