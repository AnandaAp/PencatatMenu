fun main() {
    val menu = arrayListOf<Menu>()      //variable untuk menampung seluruh menu yang disimpan
    var pilihan : String                //variable untuk menampung pilihan
    while(true){
        val tempMenu = Menu()           //variable untuk menampung menu yang akan ditambahkan
        println("===========Pencatat Menu===========")
        println("1. tampilkan menu")
        println("2. Tambahkan menu")
        println("3. Edit menu")
        print("Pilihanmu : ")
        pilihan = readLine().toString()
        when(pilihan.toInt()){
            1 -> showMenu(menu)
            2 -> addMenu(menu,tempMenu)
            3 -> editMenu(menu)
            else -> {
                println("Input yang anda masukan salah")
                println()
            }
        }
    }
}

//fungsi untuk menampilkan semua menu
fun showMenu(menu: ArrayList<Menu>) {
    println("\t\tMenu")
    if (menu.size == 0){
        println("Belum ada menu tersedia")
        println("")
    }
    else {
        var index = 1
        menu.forEach{
            println("$index.${it.menu}\n" +
                    "\tTersedia : ${it.jmlItem}")
            index++
        }
        println()
    }
}

//fungsi untuk menambah menu baru
fun addMenu(menu: ArrayList<Menu>, tempMenu: Menu) {
    println("Masukan nama dan jumlah menu")
    print("Menu : ")
    tempMenu.menu = readLine().toString()
    print("Jumlah item : ")
    tempMenu.jmlItem = readLine().toString().toInt()
    println("Data berhasil diinput")
    println("")
    menu.add(tempMenu)
}

// fungsi untuk mengedit menu
fun editMenu(menu: ArrayList<Menu>) {
    println("\t\tMenu")
    if (menu.size == 0){
        println("Belum ada menu tersedia")
        println("")
    }
    else {
        var index = 1
        menu.forEach{
            println("$index.${it.menu}\n" +
                    "\tTersedia : ${it.jmlItem}")
            index++
        }
        val limit = index-1
        println("$index. Batal")
        println()
        print("Pilih menu yang ingin diubah : ")
        when(val pilihan = readLine().toString().toInt()){
            in 1..limit -> editDetail(menu)
            pilihan -> {
                println("Proses Dibatalkan")
                println()
            }
        }
    }
}

//fungsi untuk merubah detail dari menu
fun editDetail(menu: ArrayList<Menu>) {
    println("1. Edit Nama Menu")
    println("2. Edit Jumlah Item")
    println("3. Batal")
    print("Pilihanmu : ")
    val pilihan = readLine().toString().toInt()
    val index = pilihan-1
//    if(pilihan > 3){
//        println("Input yang anda masukan salah")
//        println()
//        editDetail(menu)
//    }
//    else{
//        when (pilihan) {
//            1 -> {
//                print("Nama Menu Baru : ")
//                menu[index].menu = readLine().toString()
//                println("Data Berhasil diubah")
//                println()
//            }
//            2 -> {
//                menu[index].jmlItem = readLine().toString().toInt()
//                println("Data Berhasil diubah")
//                println()
//            }
//            3 -> {
//                println("Proses Dibatalkan")
//                println()
//            }
//        }
//    }
    when (pilihan) {
        1 -> {
            print("Nama Menu Baru : ")
            menu[index].menu = readLine().toString()
            println("Data Berhasil diubah")
            println()
        }
        2 -> {
            menu[index].jmlItem = readLine().toString().toInt()
            println("Data Berhasil diubah")
            println()
        }
        3 -> {
            println("Proses Dibatalkan")
            println()
        }
        in 3..pilihan -> {
            println("Input yang anda masukan salah")
            println()
            editDetail(menu)
        }
    }
}
