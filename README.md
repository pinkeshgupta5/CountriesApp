# CountriesApp
Android app called ‘Countries’ which will enable user to search countries based on country name and see some details of countries.
Used Rich Ui Interface and latest Android Architecture Components, Live Data,View Model,Room,Retrofit,Butterfly dependency injectons.
Online Search: This will be landing screen of the application.
This screen will be empty initially, data will be shown only when user starts search. 
There should be a search box on top, User should be able to search with country name (Use the API provided in Reference section), 
for each character entered in the search box the search result should refresh. 
The search result should be displayed as a list, each row in the list will contain the country flag and country name. 
The flag image should be loaded lazily. On selecting an item in the list, the details of the country should be shown.
Country Details: This screen will display the details of the country selected. 
This screen will have country flag, country name, capital, calling code, region, sub region, time zone, currencies and languages.
There will be a button in the screen to save the country for offline. 
On clicking of this button, the country should be persisted locally including the flag image.
Offline: When the device is offline the landing screen will show all the countries saved for offline. 
While offline the search should be performed on the saved countries, 
the save for offline button will be hidden in this flow and rest of the flow remains the same
