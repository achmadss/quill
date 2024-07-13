package com.achmadss.quill.ui.screens.home

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.achmadss.data.local.Constants
import com.achmadss.data.local.Constants.SharedPrefKeys.TEST_KEY
import com.achmadss.data.local.asFlow
import com.achmadss.data.local.put

object HomeScreen: Screen {

    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        val context = LocalContext.current
        val preferences by lazy {
            context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
        }
        val test by preferences.asFlow(TEST_KEY, "").collectAsState(initial = "")
        var textInputValue by remember { mutableStateOf("") }

        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier,
                    text = test ?: "",
                    color = Color.White
                )
                TextField(
                    value = textInputValue,
                    onValueChange = {
                        textInputValue = it
                    }
                )
                Button(
                    onClick = { preferences.put(TEST_KEY, textInputValue) }
                ) {
                    Text(text = "Update")
                }
            }
        }
    }

}

