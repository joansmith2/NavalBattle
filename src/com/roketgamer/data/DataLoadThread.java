/*
 * Copyright (C) 2013 RoketGamer <http://roketgamer.com> and contributors.
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

package com.roketgamer.data;

import com.roketgamer.Player;
import com.roketgamer.RoketGamer;

public class DataLoadThread extends Thread {
	
	private Player player;
	
	public DataLoadThread(Player player) {
		this.player = player;
		RoketGamer.getInstance().getLoggerHook().printInfo("DataLoadThread created");
	}

	@Override
	public void run() {
		player.setDataLoaded(true);
		RoketGamer.getInstance().getLoggerHook().printInfo("DataLoadThread completed");
	}
}