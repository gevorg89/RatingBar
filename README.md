# Jetpack Compose RatingBar
[![](https://jitpack.io/v/gevorg89/RatingBar.svg)](https://jitpack.io/#gevorg89/RatingBar)
> The simple RatingBar library for Jetpack Compose!

## Demo
![](images/stars.png)
### Implementation
from JitPack:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.gevorg89:RatingBar:1.0.0'
}
```

### How use
``` kotlin
RatingBar(
            modifier = Modifier
                .background(Color.Gray)
                .padding(16.dp),
            empty = {
                StarRating(R.drawable.ic_baseline_star_outline_24, width)
            },
            filled = {
                StarRating(R.drawable.ic_baseline_star_24, width)
            },
            stepSize = 0.5f,
            steps = 5,
            value = valueState,
            isIndicator = false
        ) { rating ->
            valueState = rating
        }
        Column{
            Text(text = valueState.toString())
            Button(onClick = {
                valueState = 1.5f
            }) {
                Text(text = "Change value to 1.5")
            }
        }
```
