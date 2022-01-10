package com.example

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasAnyAncestor
import androidx.compose.ui.test.isPopup
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.popupsample.DefaultPreview
import org.junit.Rule
import org.junit.Test

class PopupTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_popup() {
        composeTestRule.setContent {
            DefaultPreview()
        }
        composeTestRule.onNodeWithTag("popup").assert(hasAnyAncestor(isPopup()))
    }
}