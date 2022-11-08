package com.cyrilpillai.androidplayground.messaging.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.messaging.model.ChatItem
import com.cyrilpillai.androidplayground.messaging.model.TabItem
import com.cyrilpillai.androidplayground.messaging.ui.components.ChatState
import com.cyrilpillai.androidplayground.messaging.ui.components.FloatingActionButtonState
import com.cyrilpillai.androidplayground.messaging.ui.components.TopBarState
import com.cyrilpillai.androidplayground.utils.StorageBucket.MESSAGING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl

fun getTopBarState(): TopBarState {
    return TopBarState("WhatsApp")
}

fun getTabs(): List<TabItem> {
    return listOf(
        TabItem.Community,
        TabItem.Chat,
        TabItem.Status,
        TabItem.Call
    )
}

fun getFloatingActionButtonState(selectedTabPosition: Int): FloatingActionButtonState {
    return FloatingActionButtonState(
        when (selectedTabPosition) {
            1 -> R.drawable.ic_message
            2 -> R.drawable.ic_camera_filled
            3 -> R.drawable.ic_add_call
            else -> null
        }
    )
}

fun getChatState(): ChatState {
    return ChatState(
        listOf(
            ChatItem(
                id = 1,
                name = "Michael Scott",
                imageUrl = getQualifiedImageUrl("michael_scott", MESSAGING),
                message = "I just hope I find it along the way.",
                timestamp = "Today"
            ),
            ChatItem(
                id = 2,
                name = "Dwight Schrute",
                imageUrl = getQualifiedImageUrl("dwight_schrute", MESSAGING),
                message = "Who is Justice Beaver?",
                timestamp = "06/11/2022"
            ),
            ChatItem(
                id = 3,
                name = "Jim Halpert",
                imageUrl = getQualifiedImageUrl("jim_halpert", MESSAGING),
                message = "It's just that sometimes goodbyes are a bitch",
                timestamp = "05/11/2022"
            ),
            ChatItem(
                id = 4,
                name = "Pam Beesly",
                imageUrl = getQualifiedImageUrl("pam_beesly", MESSAGING),
                message = "I am gonna start telling people what I want, directly.",
                timestamp = "04/11/2022"
            ),
            ChatItem(
                id = 5,
                name = "Andy Bernard",
                imageUrl = getQualifiedImageUrl("andy_bernard", MESSAGING),
                message = "I get super flexible when I'm nervous.",
                timestamp = "Today"
            ),
            ChatItem(
                id = 6,
                name = "Toby Flenderson",
                imageUrl = getQualifiedImageUrl("toby_flenderson", MESSAGING),
                message = "Happy's a funny word",
                timestamp = "06/11/2022"
            ),
            ChatItem(
                id = 7,
                name = "Kelly Kapoor",
                imageUrl = getQualifiedImageUrl("kelly_kapoor", MESSAGING),
                message = "My resolution was to get more attention",
                timestamp = "05/11/2022"
            ),
            ChatItem(
                id = 8,
                name = "Darryl Philbin",
                imageUrl = getQualifiedImageUrl("darryl_philbin", MESSAGING),
                message = "I would date the hell outta me!",
                timestamp = "04/11/2022"
            ),
            ChatItem(
                id = 9,
                name = "Oscar Martinez",
                imageUrl = getQualifiedImageUrl("oscar_martinez", MESSAGING),
                message = "I consider myself  a good person, but I'm going to make him cry",
                timestamp = "Today"
            ),
            ChatItem(
                id = 10,
                name = "Erin Hannon",
                imageUrl = getQualifiedImageUrl("erin_hannon", MESSAGING),
                message = "Talk to me that way again and I'll cut your face.",
                timestamp = "06/11/2022"
            ),
            ChatItem(
                id = 11,
                name = "Karen Filippelli",
                imageUrl = getQualifiedImageUrl("karen_filippelli", MESSAGING),
                message = "It's a pretty common one",
                timestamp = "05/11/2022"
            ),
            ChatItem(
                id = 12,
                name = "Kevin Malone",
                imageUrl = getQualifiedImageUrl("kevin_malone", MESSAGING),
                message = "I have very little patience for stupidity.",
                timestamp = "04/11/2022"
            ),
            ChatItem(
                id = 13,
                name = "Ryan Howard",
                imageUrl = getQualifiedImageUrl("ryan_howard", MESSAGING),
                message = "Today was a fantastic waste of time",
                timestamp = "Today"
            ),
            ChatItem(
                id = 14,
                name = "Angela Martin",
                imageUrl = getQualifiedImageUrl("angela_martin", MESSAGING),
                message = "I don't want to blame anyone in particular",
                timestamp = "06/11/2022"
            ),
            ChatItem(
                id = 15,
                name = "Jan Levinson",
                imageUrl = getQualifiedImageUrl("jan_levinson", MESSAGING),
                message = "There are always a million reasons to not do something.",
                timestamp = "05/11/2022"
            ),
            ChatItem(
                id = 16,
                name = "Gabe Lewis",
                imageUrl = getQualifiedImageUrl("gabe_lewis", MESSAGING),
                message = "There are plenty of people who love touching me",
                timestamp = "04/11/2022"
            )
        )
    )
}