import java.util.*
import kotlin.collections.ArrayList

fun main (args: Array<String>){
    val input = Scanner(System.`in`)
    val list:ArrayList<Double> = ArrayList()
    print("Input array numbers: ")

    while (input.hasNextDouble()){
        list.add(input.nextDouble())
    }

    val arr = list.toArray(arrayOfNulls<Double>(0))
    var largest = arr[0]
    var secLargest = arr[0]

    print("Input : array ")
    for (a in 0 until arr.size) {
        print(arr[a].toString() + ", ")
    }

    for (a in 0 until arr.size) {

        if (arr[a]!! > largest!!) {
            secLargest = largest
            largest = arr[a]

        } else if (arr[a]!! > secLargest!!) {
            secLargest = arr[a]
        }
    }

    println("\nSecond Large is: " + secLargest);
}