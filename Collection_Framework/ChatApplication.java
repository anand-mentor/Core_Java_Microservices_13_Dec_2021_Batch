package com.zensar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class ChatApplication {

	private static Map<String, TreeSet> mapChatRoomUsers = new HashMap<String, TreeSet>();
	private static Map<String, ArrayList> mapChatRoomMessages = new HashMap<String, ArrayList>();
	private static Scanner scanner = new Scanner(System.in);
	
	private static void createNewChatRoom() {}
	private static void addUser() {}
	private static void login() {}
	private static void sendMessage() { }
	private static void displayMessages() { }
	private static void listUsers() {}
	private static void logout() {}
	private static void deleteUser() {}
	private static void deleteChatRoom() {}
	
	public static void main(String[] args) {
		System.out.println("Options:");
		System.out.println("A) Create a chatroom");
		System.out.println("B) Add the user");
		System.out.println("C) User login");
		System.out.println("D) Send a message");
		System.out.println("E) Display the messages from a specific chatroom");
		System.out.println("F) List down all users belonging to the specified chat room.");
		System.out.println("G) Logout");
		System.out.println("H) Delete an user");
		System.out.println("I) Delete the chat room.");
		while(true) {
			System.out.println("Please enter your option:");
			String option = scanner.nextLine();
			switch(option) {
				case "A": createNewChatRoom();
			}
		}
	}
}
