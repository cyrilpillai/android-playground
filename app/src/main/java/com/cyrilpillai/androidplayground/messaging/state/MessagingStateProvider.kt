package com.cyrilpillai.androidplayground.messaging.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.messaging.model.CallItem
import com.cyrilpillai.androidplayground.messaging.model.CallLinkItem
import com.cyrilpillai.androidplayground.messaging.model.CallMode
import com.cyrilpillai.androidplayground.messaging.model.CallStatus
import com.cyrilpillai.androidplayground.messaging.model.CallType
import com.cyrilpillai.androidplayground.messaging.model.ChatItem
import com.cyrilpillai.androidplayground.messaging.model.MessagingItem
import com.cyrilpillai.androidplayground.messaging.model.MyStatusItem
import com.cyrilpillai.androidplayground.messaging.model.StatusItem
import com.cyrilpillai.androidplayground.messaging.model.TabItem
import com.cyrilpillai.androidplayground.messaging.ui.components.CallState
import com.cyrilpillai.androidplayground.messaging.ui.components.ChatState
import com.cyrilpillai.androidplayground.messaging.ui.components.FloatingActionButtonState
import com.cyrilpillai.androidplayground.messaging.ui.components.StatusState
import com.cyrilpillai.androidplayground.messaging.ui.components.TopBarState
import com.cyrilpillai.androidplayground.utils.StorageBucket.MESSAGING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import kotlin.random.Random

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
    val smallFabIcon = if (selectedTabPosition == 2) R.drawable.ic_edit else null
    val bigFabIcon = when (selectedTabPosition) {
        1 -> R.drawable.ic_message
        2 -> R.drawable.ic_camera_filled
        3 -> R.drawable.ic_add_call
        else -> null
    }
    return FloatingActionButtonState(smallFabIcon, bigFabIcon)
}

fun getChatState(): ChatState {
    return ChatState(
        getMessagingItems().map { ChatItem(it) }
    )
}

fun getStatusState(): StatusState {
    return StatusState(
        myStatusItem = MyStatusItem(
            title = "My status",
            description = "Tap to add status update",
            imageUrl = getQualifiedImageUrl(
                relativeName = "stanley_hudson",
                storageBucket = MESSAGING
            )
        ),
        headerText = "Recent updates",
        statuses = getMessagingItems()
            .shuffled()
            .take(4)
            .map {
                StatusItem(it, Random.nextInt(7))
            }
    )
}

fun getCallState(): CallState {
    return CallState(
        linkItem = CallLinkItem(
            title = "Create call link",
            description = "Share a link for your WhatsApp call",
            icon = R.drawable.ic_link
        ),
        headerText = "Recent",
        calls = getMessagingItems()
            .shuffled()
            .map {
                val firstRandom = Random.nextBoolean()
                val secondRandom = Random.nextBoolean()
                val callType = if (firstRandom) CallType.INCOMING else CallType.OUTGOING
                val callMode = if (firstRandom) CallMode.VOICE else CallMode.VIDEO
                val callStatus =
                    if (callType == CallType.INCOMING && secondRandom) CallStatus.MISSED
                    else CallStatus.PICKED
                CallItem(it, callType, callMode, callStatus)
            }
    )
}

private fun getMessagingItems(): List<MessagingItem> {
    return listOf(
        MessagingItem(
            id = 1,
            name = "Michael Scott",
            imageUrl = getQualifiedImageUrl(
                relativeName = "michael_scott",
                storageBucket = MESSAGING
            ),
            message = "I just hope I find it along the way.",
            date = "Today",
            timestamp = "Today, 1:49 pm"
        ),
        MessagingItem(
            id = 2,
            name = "Dwight Schrute",
            imageUrl = getQualifiedImageUrl(
                relativeName = "dwight_schrute",
                storageBucket = MESSAGING
            ),
            message = "Who is Justice Beaver?",
            date = "Yesterday",
            timestamp = "Yesterday, 12:00 pm"
        ),
        MessagingItem(
            id = 3,
            name = "Jim Halpert",
            imageUrl = getQualifiedImageUrl(
                relativeName = "jim_halpert",
                storageBucket = MESSAGING
            ),
            message = "It's just that sometimes goodbyes are a bitch",
            date = "05/11/2022",
            timestamp = "2 November, 10:30 am"
        ),
        MessagingItem(
            id = 4,
            name = "Pam Beesly",
            imageUrl = getQualifiedImageUrl(
                relativeName = "pam_beesly",
                storageBucket = MESSAGING
            ),
            message = "I am gonna start telling people what I want, directly.",
            date = "04/11/2022",
            timestamp = "1 November, 09:30 am"
        ),
        MessagingItem(
            id = 5,
            name = "Andy Bernard",
            imageUrl = getQualifiedImageUrl(
                relativeName = "andy_bernard",
                storageBucket = MESSAGING
            ),
            message = "I get super flexible when I'm nervous.",
            date = "Today",
            timestamp = "8 November, 07:30 pm"
        ),
        MessagingItem(
            id = 6,
            name = "Toby Flenderson",
            imageUrl = getQualifiedImageUrl(
                relativeName = "toby_flenderson",
                storageBucket = MESSAGING
            ),
            message = "Happy's a funny word",
            date = "06/11/2022",
            timestamp = "8 November, 05:30 pm"
        ),
        MessagingItem(
            id = 7,
            name = "Kelly Kapoor",
            imageUrl = getQualifiedImageUrl(
                relativeName = "kelly_kapoor",
                storageBucket = MESSAGING
            ),
            message = "My resolution was to get more attention",
            date = "05/11/2022",
            timestamp = "3 November, 04:09 pm"
        ),
        MessagingItem(
            id = 8,
            name = "Darryl Philbin",
            imageUrl = getQualifiedImageUrl(
                relativeName = "darryl_philbin",
                storageBucket = MESSAGING
            ),
            message = "I would date the hell outta me!",
            date = "04/11/2022",
            timestamp = "2 November, 10:30 am"
        ),
        MessagingItem(
            id = 9,
            name = "Oscar Martinez",
            imageUrl = getQualifiedImageUrl(
                relativeName = "oscar_martinez",
                storageBucket = MESSAGING
            ),
            message = "I consider myself  a good person, but I'm going to make him cry",
            date = "Today",
            timestamp = "4 November, 12:30 am"
        ),
        MessagingItem(
            id = 10,
            name = "Erin Hannon",
            imageUrl = getQualifiedImageUrl(
                relativeName = "erin_hannon",
                storageBucket = MESSAGING
            ),
            message = "Talk to me that way again and I'll cut your face.",
            date = "06/11/2022",
            timestamp = "7 November, 06:30 pm"
        ),
        MessagingItem(
            id = 11,
            name = "Karen Filippelli",
            imageUrl = getQualifiedImageUrl(
                relativeName = "karen_filippelli",
                storageBucket = MESSAGING
            ),
            message = "It's a pretty common one",
            date = "05/11/2022",
            timestamp = "1 November, 10:45 am"
        ),
        MessagingItem(
            id = 12,
            name = "Kevin Malone",
            imageUrl = getQualifiedImageUrl(
                relativeName = "kevin_malone",
                storageBucket = MESSAGING
            ),
            message = "I have very little patience for stupidity.",
            date = "04/11/2022",
            timestamp = "3 November, 11:30 pm"
        ),
        MessagingItem(
            id = 13,
            name = "Ryan Howard",
            imageUrl = getQualifiedImageUrl(
                relativeName = "ryan_howard",
                storageBucket = MESSAGING
            ),
            message = "Today was a fantastic waste of time",
            date = "Today",
            timestamp = "8 November, 01:30 am"
        ),
        MessagingItem(
            id = 14,
            name = "Angela Martin",
            imageUrl = getQualifiedImageUrl(
                relativeName = "angela_martin",
                storageBucket = MESSAGING
            ),
            message = "I don't want to blame anyone in particular",
            date = "06/11/2022",
            timestamp = "3 November, 11:45 am"
        ),
        MessagingItem(
            id = 15,
            name = "Jan Levinson",
            imageUrl = getQualifiedImageUrl(
                relativeName = "jan_levinson",
                storageBucket = MESSAGING
            ),
            message = "There are always a million reasons to not do something.",
            date = "05/11/2022",
            timestamp = "5 November, 03:30 pm"
        ),
        MessagingItem(
            id = 16,
            name = "Gabe Lewis",
            imageUrl = getQualifiedImageUrl(
                relativeName = "gabe_lewis",
                storageBucket = MESSAGING
            ),
            message = "There are plenty of people who love touching me",
            date = "04/11/2022",
            timestamp = "1 November, 11:20 am"
        )
    )
}

