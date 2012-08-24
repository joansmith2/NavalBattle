/*
 * Copyright (C) 2012 JPII and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpii.navalbattle.data;

import java.util.ArrayList;

import com.jpii.navalbattle.NavalBattle;
import com.jpii.navalbattle.debug.Command;
import com.jpii.navalbattle.debug.CommandAction;

public class Constants {
	
	/*
	 * General
	 */
	public static final String NAVALBATTLE_VERSION = "1.0-dev";
	public static final String NAVALBATTLE_VERSION_TITLE = "NavalBattle " + NAVALBATTLE_VERSION;
	public static final String NAVALBATTLE_CODENAME = "Pioneer";
	public static final String NEWSFEED_URL = "https://dl.dropbox.com/u/4847494/navalbattle/news.html";
	public static final boolean DEBUG_MODE = true;
	
	/*
	 * RoketGamer
	 */
	public static final boolean ENABLE_ROKETGAMER = true;
	public static final boolean FORCE_LOGIN = true;
	public static final String API_KEY = "API_KEY";
	public static final String SERVER_LOCATION = "http://www.roketgamer.co.cc";
	
	/*
	 * Commands
	 */
	@SuppressWarnings("serial")
	public static final ArrayList<Command> COMMANDS = new ArrayList<Command>() {{
	    add(new Command("help", "", "View all commands", new CommandAction() { 
	    	public void onRun(Command c, String enteredCommand) {
	    		NavalBattle.getDebugWindow().println("----------------- NavalBattle Debug Help -----------------");
	    		for(Command cmd : NavalBattle.getCommandHandler().getCommands()) {
	    			NavalBattle.getDebugWindow().println(cmd.getCommand() + cmd.getArgs() + " - " + cmd.getDescription());
	    		}
	    	}}
	    
	    ));
	    
	    add(new Command("quit", "", "Quit game", new CommandAction() { 
	    	public void onRun(Command c, String enteredCommand) {
	    		System.exit(0);
	    	}}
	    
	    ));
	    
	    add(new Command("version", "", "View version info", new CommandAction() { 
	    	public void onRun(Command c, String enteredCommand) {
	    		NavalBattle.getDebugWindow().println(NAVALBATTLE_VERSION_TITLE + " (" + NAVALBATTLE_CODENAME + ")");
	    	}}
	    
	    ));
	    
	    add(new Command("echo", "<message>", "Print specified message", new CommandAction() { 
	    	public void onRun(Command c, String enteredCommand) {
	    		String[] s = enteredCommand.split(" ", 2);
	    		NavalBattle.getDebugWindow().println(s[1]);
	    	}}
	    
	    ));
	    
	    add(new Command("credits", "", "NavalBattle credits", new CommandAction() { 
	    	public void onRun(Command c, String enteredCommand) {
	    		NavalBattle.getDebugWindow().println("----------------- NavalBattle Credits -----------------");
	    		NavalBattle.getDebugWindow().println("Anthony \"abauer\" Bauer - game design lead");
	    		NavalBattle.getDebugWindow().println("Thomas \"TexasGamer\" Gaubert - SCM manager; RoketGamer lead");
	    		NavalBattle.getDebugWindow().println("Max \"maximusvladimir\" Kirkby - TBD");
	    		NavalBattle.getDebugWindow().println("JR \"DarkWarHero\" Vetus - TBD");
	    		NavalBattle.getDebugWindow().println("Matt \"Matthis5point0\" Waller - TBD");
	    		NavalBattle.getDebugWindow().println("Zach \"smeagle42\" Mathewson - SCM manager; RoketGamer lead");
	    		NavalBattle.getDebugWindow().println("");
	    		NavalBattle.getDebugWindow().println("GitHub - project hosting");
	    		NavalBattle.getDebugWindow().println("RoketGamer - online social gaming");
	    	}}
	    
	    ));
	    
	    add(new Command("setscore", "<score>", "Set user score to amount", new CommandAction() { 
	    	public void onRun(Command c, String enteredCommand) {
	    		String[] s = enteredCommand.split(" ", 2);
	    		try {
	    			NavalBattle.getGameState().addScore(Integer.parseInt(s[1]));
		    		NavalBattle.getDebugWindow().printInfo("Game score set to " + s[1]);
	    		} catch (Exception ex) {
	    			NavalBattle.getDebugWindow().printError("Missing or invalid arg: score");
	    		}
	    	}}
	    
	    ));
	}};
	
}
