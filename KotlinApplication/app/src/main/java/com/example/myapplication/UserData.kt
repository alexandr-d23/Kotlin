package com.example.myapplication

class UserData {


    fun getUsers(): HashMap<String,User>{
        val user1 = User("alexandr-d23@mail.ru","Alexandr","Diner","KotlinApp1",R.drawable.cat)
        val user2 = User("Nikita@gmail.com","Nikita","Ivanov","Nik482",-1)
        val user3 = User("codeforces@code.com","Gena","Korotkevich","Tourist21",R.drawable.gena)
        var table = HashMap<String,User>()
        table.put(user1.getEmail(),user1)
        table.put(user2.getEmail(),user2)
        table.put(user3.getEmail(),user3)
        return table
    }

}