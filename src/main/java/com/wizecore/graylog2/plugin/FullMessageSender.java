package com.wizecore.graylog2.plugin;

import java.util.logging.Logger;

import org.graylog2.plugin.Message;
import org.graylog2.syslog4j.SyslogIF;


/**
 * Sends full message to Syslog.
 * 
 * <165>1 2003-10-11T22:14:15.003Z mymachine.example.com
           evntslog - ID47 [exampleSDID@0 iut="3" eventSource=
           "Application" eventID="1011"] BOMAn application
           event log entry...

 */
public class FullMessageSender implements MessageSender {
	private Logger log = Logger.getLogger(FullMessageSender.class.getName());

	@Override
	public void send(SyslogIF syslog, int level, Message msg) {		
		syslog.log(level, msg.getField(Message.FIELD_FULL_MESSAGE).toString());
	}
}
