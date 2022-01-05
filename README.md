

I use os linux Fedora 35 and install package for run this projects. ->


    sudo dnf install asterisk 
    sudo dnf install asterisk-sip 
    sudo dnf install asterisk-sounds-core-en-sln16.noarch 
    

and edit /etc/asterisk/manager.conf ->

    [mehrdad] 
    secret=709059 
    deny=0.0.0.0/0.0.0.0 
    permit=127.0.0.1/255.255.255.0 
    read = system,call,log,verbose,command,agent,user,originate 
    write = system,call,log,verbose,command,agent,user,originate 

and goto asterisk cli ->\
module load chan_sip.so \
or edit /etc/asterisk/module.conf \
load => chan_sip.so 

and edit /etc/asterisk/sip.conf -> 

    [general] 
    context=default 
    bindport=5060 
    disallow=all 
    alow=ulaw 
    alow=alaw 

<br>

    [1000] 
    type=friend 
    host=dynamic 
    secret=1234 
    context=default 


and edit /etc/asterisk/extensions.conf ->


    [default] 
    exten => 888,1,Agi(agi://localhost/hello.agi)

for convert sounds mp3 to wav ->



    lame --decode file.mp3 - | sox -v 0.5 -t wav - -t wav -b 16 -r 8000 -c 1 file.wav
   
<br>
    
    ffmpeg -i file.m4a -ac 1 -ab 128k -ar 8000 -acodec pcm_s16le file.wav



and download source sound core en slin16 file with asterisk and cp /var/lib/asterisk/sounds/en 


