package com.example.myapplication

class User (private var email:String ,private var firstName:String,private var lastName: String ,private var password:String,private var idOfImage: Int){

    public fun getEmail():String{
        return this.email
    }

    public fun getFirstName():String{
        return this.firstName
    }

    public fun getLastName():String{
        return this.lastName
    }

    public fun getPassword():String{
        return this.password
    }

    public fun getIdOfImage():Int{
        return this.idOfImage
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (email != other.email) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (password != other.password) return false
        if (idOfImage != other.idOfImage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + idOfImage
        return result
    }

    override fun toString(): String {
        return "User(email='$email', firstName='$firstName', lastName='$lastName', password='$password', idOfImage=$idOfImage)"
    }

}