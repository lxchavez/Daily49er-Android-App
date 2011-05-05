/*
 *	Copyright 2011 Alex Chavez, Punravee Cherngchaosil, Amanda Nguyen
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

package daily49er.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

/**
 * The Events Tab is composed of the Daily49er's "Diversions" calendar which is
 * implemented via an embedded WebView.
 * @author Alex Chavez
 */
public class EventsTab extends Activity 
{
	//Create a new WebView object
	WebView calendarView;
	
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        calendarView = new WebView(this);
        calendarView.getSettings().setJavaScriptEnabled(true);
        String url = "https://www.google.com/calendar/embed?showTitle=0&showPrint=0&showTabs=0&showCalendars=0" +
        		"&showTz=0&mode=AGENDA&height=600&wkst=2&bgcolor=%23FFFFFF" +
        		//Error on this calendar:
        		//"&src=diversionsd49er%40gmail.com&color=%235229A3" +
        		"&src=calendard49er%40gmail.com&color=%23528800" +
        		"&src=ta3lad7oton86pe1a5u9l2eq8k%40group.calendar.google.com&color=%230D7813" +
        		"&src=d6i4qlrmtkgdpffmi1370d0to8%40group.calendar.google.com&color=%2328754E" +
        		"&src=236k2n013kavc6bh61nalpsp5g%40group.calendar.google.com&color=%23B1440E" +
        		"&src=luoc3u2led2otfvp65sb02rktk%40group.calendar.google.com&color=%234A716C" +
        		"&src=q80dbs9fuub8tkdd330ls7rvpo%40group.calendar.google.com&color=%23A32929" +
        		"&src=ol9i0lbm6iolpki1mrar2tpt08%40group.calendar.google.com&color=%231B887A" +
        		"&src=uaf7e8mhimrsqcqhp6toij9g5s%40group.calendar.google.com&color=%23AB8B00" +
        		"&src=afuqbd3vbkbj86nov7k0e6t3p4%40group.calendar.google.com&color=%23705770" +
        		"&src=1b0grqpd47ij9r0fkd90k9ktno%40group.calendar.google.com&color=%232952A3" +
        		"&src=g9qta3g7n4imnf05dmv6eqenm0%40group.calendar.google.com&color=%23B1365F" +
        		"&src=l6ps3eqn0620lerpemcvtr7ii4%40group.calendar.google.com&color=%238D6F47" +
        		//Error on this calendar:
        		//"&src=tslm8ob4srqmcepnvukmjklkeo%40group.calendar.google.com&color=%235A6986" +
        		"&src=vyabooking%40gmail.com&color=%232952A3&ctz=America%2FLos_Angeles";
       
        calendarView.setVerticalScrollBarEnabled(true);
        calendarView.setWebViewClient(new LoadPage(calendarView, url));
        setContentView(calendarView);
    }
    
    /**
     * This callback method will be called anytime a button is pressed while in the Events tab 
     * WebView; it will go back to a previous page in the webview.
     * @param keyCode - the key code that is passed whenever any of the standard device buttons are 
     * pressed.
     * @param keyEvent - the event that is triggered by the button press.
     * @return true - if the "back" button has been pressed; then return the event and keycode for
     * the button that was pressed.
     */
     @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
        if((keyCode == KeyEvent.KEYCODE_BACK) && calendarView.canGoBack()) 
        {
            calendarView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}