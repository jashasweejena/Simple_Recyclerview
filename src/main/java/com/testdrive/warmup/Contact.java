package com.testdrive.warmup;

import java.util.ArrayList;

/**
 * Created by Jashaswee on 2/10/2018.
 */

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String xyz, boolean abc)
    {
        mName = xyz;
        mOnline = abc;
    }

    public String getName()
    {
        return mName;
    }

    public boolean isOnline()
    {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactList(int numContacts)
    {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for(int i=0;i<numContacts;i++)
        {
            contacts.add(new Contact("Person" + ++lastContactId, i <= numContacts / 2));
        }
        return contacts;
    }
}
