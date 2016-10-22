/*
 * Copyright (c) 2015-2016 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.certmgr.certs.net;

import java.io.IOException;
import java.net.Socket;

class SMTPStartTLSHelper extends StartTLSHelper {

	public SMTPStartTLSHelper(Socket plainSocket) {
		super(plainSocket);
	}

	@Override
	public void start() throws IOException {
		while (true) {
			String reply = receiveAll("\r\n");

			if (reply.startsWith("220 ")) {
				break;
			}
		}
		send("STARTTLS\r\n");
		while (true) {
			String reply = receiveAll("\r\n");

			if (reply.startsWith("220 ")) {
				break;
			} else if (reply.startsWith("501 ") || reply.startsWith("454 ")) {
				throw new IOException("StartTLS not supported by peer");
			}
		}
	}

}