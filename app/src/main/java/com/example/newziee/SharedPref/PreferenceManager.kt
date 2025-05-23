package com.example.newziee.SharedPref

import android.content.Context
import com.example.newziee.data.contact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private const val SHARED_PREF_NAME = "InfoPref"
private const val KEY_FOR_TOOK = "InfoKey"

open class PreferenceManager(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    private val gson: Gson = Gson()

    private fun loadList(): MutableList<contact> {      // loading all the contact list if exist returning else empty list
        val json = sharedPreferences.getString(KEY_FOR_TOOK, null)
        val type = object : TypeToken<MutableList<contact>>() {}.type
        return json?.let { gson.fromJson(json, type) } ?: mutableListOf()
    }

    private fun saveData(value: List<contact>) {         // to save data we will use that thing up
        val infoContacts = gson.toJson(value)
        editor.putString(KEY_FOR_TOOK, infoContacts).apply()
    }

    fun clearAll() = editor.remove(KEY_FOR_TOOK).apply()  // to clear all

    fun addContact(contact: contact) {
        val list = loadList()
        if (!list.contains(contact)) {
            list.add(contact)
            saveData(list)
        }
    }

    fun editContact(oldContact: contact,newContact:contact) {
        val list = loadList()
        val index = list.indexOfFirst { it == oldContact }
        if (index != -1) {
            list[index] = newContact
            saveData(list)
        }
    }

    fun deleteContact(contact: contact): MutableList<contact> {
        val list = loadList()
        val updatedList = list.filter { it != contact }
        saveData(updatedList)
        return loadList()
    }

    fun getAllContact(): MutableList<contact> = loadList()

}