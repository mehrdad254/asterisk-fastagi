package com.mhr.asterisk.dialplane;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;

public class HelloAgiScript extends BaseAgiScript {
	
	private String Number = "1999";

	public void service(AgiRequest request, AgiChannel channel)
            throws AgiException
    {
		
		
		
//        exec("Playback","custom/pedarkhande");
		System.out.println("User CallerId  : " + request.getCallerIdNumber());
		System.out.println("Astersik Version : " + request.getAsteriskVersion());
		System.out.println("User Name " + request.getCallerIdName());
		System.out.println("User Context extension : " + request.getContext());
//        answer();
//        exec("Background","welcome");
//        exec("NoOp","NoOp for test!!!");
//        exec("Playback","to-enter-a-number");
//        exec("WaitExten","2.5");
//        exec("Verbose","verbose for test!!!");
//        exec("Read","Number,,4,10,3");
//        exec("SayNumber","${NUMBER}");
//        exec("Background","vm-goodbye");
//        hangup(); 
		
		channel.answer();
		exec("WaitExten","5");
		channel.waitForDigit(5);
        channel.streamFile("welcome");
        channel.sayNumber(Number);
        channel.sayDigits(Number);
        channel.sayAlpha("mehrad");
        channel.setVariable("myvar", "Mohammad Javad");
        channel.streamFile("vm-goodbye");
        channel.hangup();

        
    }
}