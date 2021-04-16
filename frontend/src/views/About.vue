<template>
  <div class = "about_container">
    <header id="header" class = "head">
        <h1>The Developers of </h1>
        <img class="logo" src="@/assets/TEHOOT.png">
        <h1>a Flashcard Application</h1>
    </header>
    <div class="bio" id="arwen">
      <img src="@/assets/Arwen.png" />
      <div class="about">
          <h1>Arwen Eger</h1>
        <p>
          Arwen is an innovator who grew up in Australia, loves the design process and seeks to make all things more harmonious. She's excited by leading-edge technology and is a passionate advocate with an emphasis on empowering women. Her interests include movies, concerts, art, design, fashion, yoga, dancing, travel and her Siberian cat, Jon Snow.
          </p>
      </div>
    </div>
    <div class="bio" id="lindsay">
      <img src="@/assets/Lindsay.jpeg" />
      <div class="about">
          <h1>Lindsay Leigh</h1>
        <p>
          When Lindsay discovered the joy of coding, she considered it just another craft to add to her hobby collection, but quickly realized that it was something she wanted to pursue as a career! In her free time, she enjoys knitting herself many sweaters, yoga, and giving her two dogs and two cats lots of love. 
        </p>
      </div>
    </div>
    <div class="bio" id="diya">
      <img src="@/assets/Diya.png" />
      <div class="about">
          <h1>Diya Loveson</h1>
        <p>
          Diya grew up in India and moved to the US in 2012. She likes to solve problems by careful analysis and is a believer of the growth mindset. She enjoys reading, writing, watching movies in 5 languages and spending time her two boys.
          </p>
      </div>
    </div>
    <div class="bio" id="vinny">
      <img src="@/assets/Vinny.png" />
      <div class="about">
          <h1>Vinny Conteen</h1>
        <p>
          Vinny is a Pittsburgh native. He enjoys coding because he loves the process of bringing new ideas to life. When he's not by his computer you can find him trying new local food, playing games with friends, or taking his very demanding dog out for a walk.
          </p>
      </div>
    </div>
    <footer id="footer">
        <img class="owl-img" src="@/assets/TEHOOTOwl.png">
    </footer>

  </div>
</template>

<style>
/*html {
    background-color: #7DDFA4;
}*/
.head {
    display: flex;
    justify-content: center;
    margin-bottom: 0px;
}
.logo {
    max-width: 500px;
  }
.ab{
  background-color: #7DDFA4;
  }
.about_container {
    margin: 10px;
    padding-left: 65px;
    padding-right: 65px;
    font-family: sans-serif;
    display: grid;
    grid-template-columns: 2fr 2fr;
    grid-gap: 30px;
    grid-template-areas:
        "header header"
        "arwen diya"
        "lindsay vinny"
        "footer footer";
  }
#header {
    grid-area: header; 
}
#arwen {
    grid-area: arwen;
}
#diya {
    grid-area: diya;
}
#lindsay {
    grid-area: lindsay;
}
#vinny {
    grid-area: vinny;
}
#footer {
    grid-area: footer;
}
  .bio {
    background-color: #F0F0F0;
    padding: 10px;
    border: solid 2px rgb(3, 3, 3);
    display: flex;
    align-items: center;
    
  }
  .bio img {
    max-height: 200px;
    max-width: 200px;
    border-radius: 800px;
    margin: 10px;
  }
  .bio:nth-child(1) img {
    order: 2;
  }
 #footer {
     display: flex;
     justify-content: center;
 } 
.owl-img {
    max-width: 200px;
}
h1 {
    line-height: 20px;
}
p {
    line-height: 24px;
}

</style>

