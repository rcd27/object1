-dontpreverify
-repackageclasses ''
-allowaccessmodification
-optimizations !code/simplification/arithmetic
-keepattributes *Annotation*

-keep class androidx.test.runner.AndroidJUnitRunner
-keepclassmembers class **.R$* {
    public static <fields>;
}
