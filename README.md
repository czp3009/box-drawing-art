# Box Drawing Art
Use box-drawing character to make sentence.

# dependence
## Maven

    <dependency>
      <groupId>com.hiczp</groupId>
      <artifactId>box-drawing-art</artifactId>
      <version>1.0</version>
    </dependency>

## Gradle

    compile group: 'com.hiczp', name: 'box-drawing-art', version: '1.0'

# Usage
## Java
```java
System.out.println(BoxDrawingArt.convert("Box Drawing Art"));
```

## Kotlin
```kotlin
println("Box Drawing Art".toBoxDrawingArt())
```

console:

    ┬┐ ┌─┐┬ ┬   ┬─┐┬─┐┌─┐┬ ┬ ┬ ┌┐┌┌─┐   ┌─┐┬─┐┌┬┐
    ├┴┐│ │└┬┘   │ │├┬┘├─┤│││ │ ││││ ┐   ├─┤├┬┘ │ 
    ┴─┘└─┘┴ ┴   ┴─┘┴└─┴ ┴└┴┘ ┴ ┘└┘└─┘   ┴ ┴┴└─ ┴ 

# License
GPL V3
