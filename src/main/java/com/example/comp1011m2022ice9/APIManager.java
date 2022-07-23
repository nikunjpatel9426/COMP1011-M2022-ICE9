package com.example.comp1011m2022ice9;

public class APIManager {
    /******************singleton*****************/
    // Step 1. private static instance member variable
    private static APIManager m_instance = null;

    // Step 2. make the default constructor private
    private APIManager() {}

    // Step 3. Create a public static entry point / instance method
    public static APIManager Instance() {

        //Step 4. Check if the private instance member variable is null
        if (m_instance == null) {

            //Step 5. Initiate a new DBMember instance
            m_instance = new APIManager();
        }
        return m_instance;
    }

    /*************************/
}
