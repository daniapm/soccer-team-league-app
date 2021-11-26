package com.dania.soccer_team_league_app.commons

import org.junit.Assert
import org.junit.Test

class ExtensionsTest {

    @Test
    fun `when text contain host`() {
        // Arrange
        val text = "https://twitter.com/alaves"
        // Act
        val result = text.toUrl()
        // Assert
        Assert.assertEquals(text, result)
    }

    @Test
    fun `when text contain no host`() {
        // Arrange
        val expected = "https://twitter.com/alaves"
        val text = "twitter.com/alaves"
        // Act
        val result = text.toUrl()
        // Assert
        Assert.assertEquals(expected, result)
    }
}