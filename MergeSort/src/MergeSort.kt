import java.util.*

fun main(args: Array<String>) {

    print("Input array numbers: ")
    val array = readLine()!!.split(" ").map { it.toInt() }.toIntArray() // 1. baca masukan dan split menjadi array integer

    println("Before Sorted " + Arrays.toString(array))

    mergeSort(array)

    println("After Sorted  " + Arrays.toString(array))
}

fun mergeSort(array: IntArray, helper: IntArray = IntArray(array.size), low: Int = 0, high: Int = array.size - 1) {
    if (low < high) {
        val middle: Int = (low + high) / 2 // 2. hitung elemen tengah dari array, bagi dua array tersebut
        mergeSort(array, helper, low, middle) // 3. sortir bagian kiri
        mergeSort(array, helper, middle + 1, high) // 4. sortir bagian kanan

        mergeArray(array, helper, low, middle, high) // 5. gabung kan kembali array tersebut


    }
}

fun mergeArray(array: IntArray, helper: IntArray, low: Int, middle: Int, high: Int) {

    // a. copy kedua bagiannya ke dalam array helper

    for (i in low..high) helper[i] = array[i]

    // b. variabel helper kiri dan kanan
    var helperLeft = low
    var helperRight = middle + 1

    var current = low

    // iterasi helper array. bandingkan kiri dan kanan copy element terkecil dari keduanya ke dalam array asli

    while (helperLeft <= middle && helperRight <= high) { // c. kondisi untuk mengecek helper kiri dan helper kanan
        if (helper[helperLeft] <= helper[helperRight]) { // d. cek jika nilai pada indeks helper kiri lebih kecil atau sama dengan indeks helper kanan
            array[current] = helper[helperLeft]
            helperLeft++
        } else {
            array[current] = helper[helperRight]
            helperRight++
        }

        current++
    }


    val remaining = middle - helperLeft
    for (i in 0..remaining) {
        array[current + i] = helper[helperLeft + i]
    }

}
