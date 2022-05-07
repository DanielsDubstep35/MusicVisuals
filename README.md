# Music Visualiser Project

Name: Daniel Mendes

Student Number: C20489272

Name: Aoife Fitzpatrick

Student Number: C20701701

## Instructions
Run the program file Maincontroller.java, and use the up and down arrow keys to cycle through the menu options. If you want to select a menu option, press right or left arrow keys. The visualizer will then start.

press the numbers 0-9 to change the music visualizer. the song plays automatically

# Assignment Report:

Day 1 (7th of March): Most of this day was spent trying to familiarize myself with github, aswell as learning more about the processing library. My ideas at the time were to incorporate Animation into my project, such as making an image move, so I spent a lot of the day trying things out in vscode. I ended up leaving the idea until I had the foundation of my project built. Oh, I also added a textfile to my project, just so I could test out commiting things and pushing them to github.

Day 2 (10th of March): Similar to day 1 in the sense that I learned a lot by watching videos on processing, aswell as looking up the documentation. This gave me a lot of ideas for my project, and I started to have a solid idea of what I wanted to make. I also developed a plan in which features I would implement, starting with the easier features such as a basic audio visualizer, a start menu, and controller support, and then working up to some of the harder challenges, such as creating my own art assets, making animations, making a more complex audio visualizer, etc.

Day 3 (12th of March): Created a simple music visualizer, as well as a main menu. Most of the code I came up with myself, and past labs such as the audio lab, or the bugzap lab in which I previously failed to create a main menu were all very good learning experiences for this day.

Day 4 (13th of March): Discussed with my partner to change the direction of the music visualizer project. Created assets for the assignment, and experimented with them. Changed and optimized some code, so that it can work faster on my machine (Macbook air), although plans for an options section is coming soon, so that visual quality is not effected on faster devices.

Days 5 – 11 (14th of March): These days during review week was spent only on the OOP assignment. I did a lot of experimenting and even more research into many of the different libraries I could use to help my idea for this assignment come true. I couldn’t get green, a processing library that makes it easier to make video games with processing, to work inside of visual studio code, so I instead tried to make controls without the library, while also making certain elements reactive to code. 

One of the reasons why I was researching using green in the first place was that:
1.	if I could make something that could combine music with video games, it would definitely stand out, and it would best showcase my skill and creativity when it comes to coding this assignment.
2.	The description for this assignment is a “Music Visual Experience”. A good amount of Games out there are labeled as Experiences, and I think that Games provide one of the most immersive and best Experiences out there by emersing you in a world or story that you can either relate to, or appreciate.
3.	‘Tetris: Effect’, one of my personal favorite video games, labels itself as an “Experience”. The game is normal tetris, except the music and visuals on screen react to every block moved, placed and rotated. As well as this, matched lines cause the music in the game to advance, making for interesting visuals based on the music. This game heavily inspired me for this project, due to how it felt like how the game was more music based, instead of the normal puzzle game that we are used to.
4.	I saw past projects from students who did this assignment, and while some of them were a game, or did have a game theme, none of them took the idea further, by adding a reactive environment, or mixing the music and game elements together. While I knew that this would be a lot of work, I also knew that it was an idea that would be pretty original, if I managed to pull it off.

I made a character and I got it to move, but it wasn’t viable and making it work without any using any libraries would take much longer to work than 8 weeks. During these weeks, a lot of the code I wrote, I ended up scrapping it. The end of review week made me think about switching to the original idea of a normal visualizer, because despite starting earlier, what I wanted to do for this project was looking much more ambitious than I anticipated.

Day 12 (27th of March): I got green, a processing library for making games, to work inside of visual studio code. While adding a library seems simple, there isnt much information online about it. This is due to the “referenced library” option not working in visual studio code sometimes. All you need to do really, is add the path of the .jar file to the .classpath file (which is hidden by default in visual studio code, you have to change your settings to display hidden files within visual studio code). With this day, I experimented with green, which definitely made things easier, and allowed me to make my code a little bit more complex by using inheritence.

Day 13 (31st of March): Got the Movement to work, I just need to add a Jump now. Since I still need to make the Music Visualiser, I wont, or shouldn’t add any more movement modes right now (such as wall jumping, ducking, etc). Fixed a few bugs aswell that related to the Movement.

Day 14 (4th of May): A lot of unrecorded progress. I scrapped the first Idea, and then I had another idea to make tetris with a music visualizer which I also scrapped. I think I will try and make something simple, but impressive.

Update: I finished the assignment, and I made something really simple. You can input from 0-9, and everything is finished and reacts to music, but it is really really basic.
Most of it is, changing shapes position and/or color based on sound.

# How it works

The user presses numbers from 0 to 9, and then that visualizer is chosen.
There is also a menu, which changes a bunch of variables to the menu option (Example, option 0 is start, while option 1 is exit)

![Screenshot 2022-05-07 at 06 47 17](https://user-images.githubusercontent.com/98469510/167240431-eec5e595-90da-4954-97b4-182c7e933993.png)

most of the visualizers from the assignment are simple shapes and colors changing based on the amplitude in the program

The draw() method calls a function called FinalVersion, which in turn displays the selected visualizer

# What I am most proud of in the assignment

How much I learned about java and processing as a whole. the last 2 visualizers taught me about inheritance, and constructors, but I also got better and faster at coding in java. I also am proud of what I managed to get done in a short amount of time.

My favorite visualizers were 8 and 9, since they were both very colorful, and looked cool

```Java
case 8:
	background(0);
	for (int i = 0; i < ab.size(); i++) {

	    // map c to the range of 0 to 255
	    float c = map(i, 0, ab.size(), 0, 255);
	    float f = lerpedBuffer[i] * (height / 2) * 20.0f;

	    stroke(c, 255, 255);
	    fill(0, 0, 0);
	    triangle( width / 2 - f, height / 2 + f, width / 2, height/2 + f, width / 2 + f, height / 2 + f);
	}
	break;

case 9:
	background(0);
	rectMode(CENTER);
	for (int i = 0; i < ab.size(); i++) {

	    // map c to the range of 0 to 255
	    float c = map(i, 0, ab.size(), 0, 255);
	    float f = lerpedBuffer[i] * (height / 2) * 20.0f;

	    stroke(c, 255, 255);
	    fill(0, 0, 0);
	    curve(width / 2, height / 2, width / 2, height / 2 + f, width / 2 + f, height / 2 + f, width / 2 + f, height / 2);

	    stroke(c, 255, 255);
	    fill(0, 0, 0);
	    bezier(width / 2, height / 2, width / 2, height / 2 + f, width / 2 + f, height / 2 + f, width / 2 + f, height / 2);
	}
	break;
```

Finally, heres the Youtube video of the assignment in action:

[![YouTube](https://www.youtube.com/watch?v=21Q2ZVyAuiI)

