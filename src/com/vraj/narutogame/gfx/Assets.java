package com.vraj.narutogame.gfx;

import java.awt.image.BufferedImage;



public class Assets {


	public static BufferedImage characterBg, smallR, bigRock, woodFloor, narutoBg, pauseBg, mountainBg, keys, volume, win1, win2, tie;


	public static BufferedImage narutoHP, sasukeHP, sakuraHP, kakashiHP, nejiHP, shikamaruHP, narutoHPL, sasukeHPL, sakuraHPL, kakashiHPL, nejiHPL, shikamaruHPL, narutoBlade, narutoTK, 
	narutoTKL, rasengan, fireball, fireballL, lightning, lightningL, dust, narutoW, sasukeW, sakuraW, nejiW, kakashiW, shikamaruW, bg2;


	//animation arrays
	public static BufferedImage[] narutoWalkingRight, narutoStandingR, narutoStandingL, narutoWalkingLeft, narutoJumpR, narutoJumpL, narutoRunningRight, narutoRunningLeft, narutoFalling,narutoPunch,
	sasukeWalkingRight, sasukeStandingR, sasukeStandingL, sasukeWalkingLeft, sasukeJumpR, sasukeJumpL, sasukeRunningRight, sasukeRunningLeft, sasukeFalling,
	sakuraWalkingRight, sakuraStandingR, sakuraStandingL, sakuraWalkingLeft, sakuraJumpR, sakuraJumpL, sakuraRunningRight, sakuraRunningLeft, sakuraFalling,
	kakashiWalkingRight, kakashiStandingR, kakashiStandingL, kakashiWalkingLeft, kakashiJumpR, kakashiJumpL, kakashiRunningRight, kakashiRunningLeft, kakashiFalling,
	nejiWalkingRight, nejiStandingR, nejiStandingL, nejiWalkingLeft, nejiJumpR, nejiJumpL, nejiRunningRight, nejiRunningLeft, nejiFalling,
	shikamaruWalkingRight, shikamaruStandingR,shikamaruStandingL,shikamaruWalkingLeft, shikamaruJumpR, shikamaruJumpL, shikamaruRunningRight, shikamaruRunningLeft, shikamaruFalling;


	public static void init() {

		//Wood platform
		SpriteSheet extras = new SpriteSheet(ImageLoader.loadImage("/images/mapSprite2.png"));

		//Character special abilities
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/naruto_sheet.png"));
		SpriteSheet fireballsheet = new SpriteSheet(ImageLoader.loadImage("/images/fireball.png"));
		SpriteSheet rasengansheet = new SpriteSheet(ImageLoader.loadImage("/images/rasengan.png"));
		SpriteSheet lightningsheet = new SpriteSheet(ImageLoader.loadImage("/images/lightning.png"));

		//Character animation spritesheet
		SpriteSheet naruto = new SpriteSheet(ImageLoader.loadImage("/images/naruto.png"));
		SpriteSheet sasuke = new SpriteSheet(ImageLoader.loadImage("/images/sasukeSprite.png"));
		SpriteSheet sakura = new SpriteSheet(ImageLoader.loadImage("/images/sakuraSprite.png"));
		SpriteSheet kakashi = new SpriteSheet(ImageLoader.loadImage("/images/kakashiSprite.png"));
		SpriteSheet neji = new SpriteSheet(ImageLoader.loadImage("/images/nejiSprite.png"));
		SpriteSheet shikamaru = new SpriteSheet(ImageLoader.loadImage("/images/shikamaruSprite.png"));


		//Character HP
		SpriteSheet narutoHPS = new SpriteSheet(ImageLoader.loadImage("/images/narutoHP.PNG"));
		SpriteSheet sasukeHPS = new SpriteSheet(ImageLoader.loadImage("/images/sasukeHP.PNG"));
		SpriteSheet sakuraHPS = new SpriteSheet(ImageLoader.loadImage("/images/sakuraHP.PNG"));
		SpriteSheet kakashiHPS= new SpriteSheet(ImageLoader.loadImage("/images/kakashiHP.PNG"));
		SpriteSheet nejiHPS = new SpriteSheet(ImageLoader.loadImage("/images/nejiHP.PNG"));
		SpriteSheet rockleeHPS = new SpriteSheet(ImageLoader.loadImage("/images/shikamaruHP.PNG"));

		narutoW = ImageLoader.loadImage("/images/narutopodium.png");
		sasukeW = ImageLoader.loadImage("/images/sasukepodium.png");
		sakuraW = ImageLoader.loadImage("/images/sakurapodium.png");
		nejiW = ImageLoader.loadImage("/images/nejipodium.png");
		kakashiW = ImageLoader.loadImage("/images/kakashipodium.png");
		shikamaruW = ImageLoader.loadImage("/images/shikamarupodium.png");

		bg2 = ImageLoader.loadImage("/images/bg2.png");

		win1 = ImageLoader.loadImage("/images/win1.jpeg");
		win2 = ImageLoader.loadImage("/images/win2.jpeg");
		tie = ImageLoader.loadImage("/images/tie.jpeg"); 

		keys = ImageLoader.loadImage("/images/AllKeys.png");
		volume = ImageLoader.loadImage("/images/volume.png");

		characterBg = ImageLoader.loadImage("/images/characterBg.jpg");
		pauseBg = (ImageLoader.loadImage("/images/narutopause.jpg"));

		narutoBg = (ImageLoader.loadImage("/images/narutobackground.jpg"));


		smallR = (ImageLoader.loadImage("/images/smallRock.png"));
		bigRock = (ImageLoader.loadImage("/images/bigRock.png"));
		woodFloor = extras.crop(220, 322, 49, 13);

		narutoBlade = (sheet.crop(363, 878, 377-363+1, 892-878+1));
		narutoTK = sheet.crop(264, 880, 20, 9);
		narutoTKL = ImageLoader.flip(narutoTK);
		rasengan = rasengansheet.crop(12, 10, 33, 33); //sheet.crop(264, 133, 30, 31);
		fireball = fireballsheet.crop(9, 12, 45, 30);
		fireballL = ImageLoader.flip(fireball);
		dust = sheet.crop(265, 801, 47, 33);
		lightning = lightningsheet.crop(87, 57, 67, 46);
		lightningL = ImageLoader.flip(lightning);


		narutoHP = narutoHPS.crop(17, 17, 214, 75);
		sasukeHP = sasukeHPS.crop(17, 17, 214, 75); 
		sakuraHP = sakuraHPS.crop(17, 17, 214, 75);
		kakashiHP = kakashiHPS.crop(17, 17, 214, 75);
		nejiHP = nejiHPS.crop(17, 17, 214, 75);
		shikamaruHP = rockleeHPS.crop(17, 17, 214, 75);

		narutoHPL = ImageLoader.flip(narutoHP);
		sasukeHPL = ImageLoader.flip(sasukeHP);
		sakuraHPL = ImageLoader.flip(sakuraHP);
		kakashiHPL = ImageLoader.flip(kakashiHP);
		nejiHPL = ImageLoader.flip(nejiHP);
		shikamaruHPL = ImageLoader.flip(shikamaruHP);


		//******************NARUTO**************************\\

		////////////////////////
		narutoFalling = new BufferedImage[2];

		narutoFalling[0] = naruto.crop(1, 396, 36, 55);
		narutoFalling[1] = naruto.crop(37, 396, 36, 55);


		////////////////////////
		narutoJumpR = new BufferedImage[2];

		narutoJumpR[0] = naruto.crop(1, 330, 50, 54);
		narutoJumpR[1] = naruto.crop(53, 330, 50, 54);

		////////////////////////
		narutoJumpL = new BufferedImage[2];

		narutoJumpL[0] = ImageLoader.flip(naruto.crop(1, 330, 50, 54));
		narutoJumpL[1] = ImageLoader.flip(naruto.crop(53, 330, 50, 54));


		////////////////////////////////////////
		narutoWalkingLeft = new BufferedImage[6];

		narutoWalkingLeft[0] = ImageLoader.flip(naruto.crop(1, 84, 36, 51));
		narutoWalkingLeft[1] = ImageLoader.flip(naruto.crop(39, 84, 36, 51));
		narutoWalkingLeft[2] = ImageLoader.flip(naruto.crop(77, 84, 36, 51));
		narutoWalkingLeft[3] = ImageLoader.flip(naruto.crop(114, 84, 36, 51));
		narutoWalkingLeft[4] = ImageLoader.flip(naruto.crop(153, 84, 36, 51));
		narutoWalkingLeft[5] = ImageLoader.flip(naruto.crop(191, 84, 36, 51));

		///////////////////////////
		narutoWalkingRight = new BufferedImage[6];

		narutoWalkingRight[0] = naruto.crop(1, 84, 36, 51);
		narutoWalkingRight[1] = naruto.crop(39, 84, 36, 51);
		narutoWalkingRight[2] = naruto.crop(77, 84, 36, 51);
		narutoWalkingRight[3] = naruto.crop(114, 84, 36, 51);
		narutoWalkingRight[4] = naruto.crop(153, 84, 36, 51);
		narutoWalkingRight[5] = naruto.crop(191, 84, 36, 51);

		////////////////////////////////
		narutoRunningRight = new BufferedImage[6];

		narutoRunningRight[0] = naruto.crop(11, 152, 45, 45);
		narutoRunningRight[1] = naruto.crop(71, 149, 60, 45);
		narutoRunningRight[2] = naruto.crop(144, 152, 60, 45);
		narutoRunningRight[3] = naruto.crop(215, 153, 58, 41);
		narutoRunningRight[4] = naruto.crop(286, 155, 58, 41);
		narutoRunningRight[5] = naruto.crop(358, 155, 58, 41);

		////////////////////////////////
		narutoRunningLeft = new BufferedImage[6];

		narutoRunningLeft[0] = ImageLoader.flip(naruto.crop(11, 152, 45, 45));
		narutoRunningLeft[1] = ImageLoader.flip(naruto.crop(71, 149, 60, 45));
		narutoRunningLeft[2] = ImageLoader.flip(naruto.crop(144, 152, 60, 45));
		narutoRunningLeft[3] = ImageLoader.flip(naruto.crop(215, 153, 58, 41));
		narutoRunningLeft[4] = ImageLoader.flip(naruto.crop(286, 155, 58, 41));
		narutoRunningLeft[5] = ImageLoader.flip(naruto.crop(358, 155, 58, 41));

		////////////////////
		narutoStandingR = new BufferedImage[4];

		narutoStandingR[0] = naruto.crop(3, 17, 36, 51);
		narutoStandingR[1] = naruto.crop(46, 17, 36, 51);
		narutoStandingR[2] = naruto.crop(91, 17, 36, 51);
		narutoStandingR[3] = naruto.crop(137, 17, 36, 51);

		////////////////////
		narutoStandingL = new BufferedImage[4];

		narutoStandingL[0] = ImageLoader.flip(naruto.crop(3, 17, 36, 51));
		narutoStandingL[1] = ImageLoader.flip(naruto.crop(46, 17, 36, 51));
		narutoStandingL[2] = ImageLoader.flip(naruto.crop(91, 17, 36, 51));
		narutoStandingL[3] = ImageLoader.flip(naruto.crop(137, 17, 36, 51));

		////////////////////
		narutoPunch = new BufferedImage[4];

		narutoPunch[0] = ImageLoader.flip(naruto.crop(3, 705, 49, 55));
		narutoPunch[1] = ImageLoader.flip(naruto.crop(63,705, 49, 55));
		narutoPunch[2] = ImageLoader.flip(naruto.crop(128, 705, 52, 55));
		narutoPunch[3] = ImageLoader.flip(naruto.crop(186, 705, 48, 55));

		//*****************************SASUKE*************************************\\


		////////////////////////
		sasukeJumpR = new BufferedImage[2];

		sasukeJumpR[0] = sasuke.crop(8, 329, 38, 50);
		sasukeJumpR[1] = sasuke.crop(50, 330, 38, 50);

		////////////////////////
		sasukeJumpL = new BufferedImage[2];

		sasukeJumpL[0] = ImageLoader.flip(sasuke.crop(8, 329, 38, 50));
		sasukeJumpL[1] = ImageLoader.flip(sasuke.crop(50, 330, 38, 50));


		////////////////////////////////////////
		sasukeWalkingLeft = new BufferedImage[6];

		sasukeWalkingLeft[0] = ImageLoader.flip(sasuke.crop(7, 81, 36, 46));
		sasukeWalkingLeft[1] = ImageLoader.flip(sasuke.crop(58, 84, 36, 46));
		sasukeWalkingLeft[2] = ImageLoader.flip(sasuke.crop(107, 84, 36, 46));
		sasukeWalkingLeft[3] = ImageLoader.flip(sasuke.crop(159, 84, 36, 46));
		sasukeWalkingLeft[4] = ImageLoader.flip(sasuke.crop(208, 84, 36, 46));
		sasukeWalkingLeft[5] = ImageLoader.flip(sasuke.crop(253, 84, 38, 46));

		///////////////////////////
		sasukeWalkingRight = new BufferedImage[6];

		sasukeWalkingRight[0] = sasuke.crop(7, 81, 36, 46);
		sasukeWalkingRight[1] = sasuke.crop(58, 84, 36, 46);
		sasukeWalkingRight[2] = sasuke.crop(107, 84, 36, 46);
		sasukeWalkingRight[3] = sasuke.crop(159, 84, 36, 46);
		sasukeWalkingRight[4] = sasuke.crop(208, 84, 36, 46);
		sasukeWalkingRight[5] = sasuke.crop(253, 84, 38, 46);

		////////////////////////////////
		sasukeRunningRight = new BufferedImage[6];

		sasukeRunningRight[0] = sasuke.crop(7, 149, 43, 46);
		sasukeRunningRight[1] = sasuke.crop(62, 149, 50, 46);
		sasukeRunningRight[2] = sasuke.crop(128, 149, 43, 45);
		sasukeRunningRight[3] = sasuke.crop(188, 145, 43, 48);
		sasukeRunningRight[4] = sasuke.crop(246, 150, 43, 43);
		sasukeRunningRight[5] = sasuke.crop(310, 150, 42, 43);

		////////////////////////////////
		sasukeRunningLeft = new BufferedImage[6];

		sasukeRunningLeft[0] = ImageLoader.flip(sasuke.crop(7, 149, 43, 46));
		sasukeRunningLeft[1] = ImageLoader.flip(sasuke.crop(62, 149, 50, 46));
		sasukeRunningLeft[2] = ImageLoader.flip(sasuke.crop(128, 149, 43, 45));
		sasukeRunningLeft[3] = ImageLoader.flip(sasuke.crop(188, 145, 43, 48));
		sasukeRunningLeft[4] = ImageLoader.flip(sasuke.crop(246, 150, 43, 43));
		sasukeRunningLeft[5] = ImageLoader.flip(sasuke.crop(310, 150, 42, 43));

		////////////////////
		sasukeStandingR = new BufferedImage[4];

		sasukeStandingR[0] = sasuke.crop(4, 16, 36, 51);
		sasukeStandingR[1] = sasuke.crop(51, 16, 36, 51);
		sasukeStandingR[2] = sasuke.crop(95, 16, 36, 51);
		sasukeStandingR[3] = sasuke.crop(137, 16, 36, 51);

		////////////////////
		sasukeStandingL = new BufferedImage[4];

		sasukeStandingL[0] = ImageLoader.flip(sasuke.crop(4, 16, 36, 51));
		sasukeStandingL[1] = ImageLoader.flip(sasuke.crop(51, 16, 36, 51));
		sasukeStandingL[2] = ImageLoader.flip(sasuke.crop(95, 16, 36, 51));
		sasukeStandingL[3] = ImageLoader.flip(sasuke.crop(137, 16, 36, 51));

		//*****************************SAKURA*************************************\\


		////////////////////////
		sakuraJumpR = new BufferedImage[2];

		sakuraJumpR[0] = sakura.crop(5, 339, 31, 46);
		sakuraJumpR[1] = sakura.crop(43, 339, 38, 49);

		////////////////////////
		sakuraJumpL = new BufferedImage[2];

		sakuraJumpL[0] = ImageLoader.flip(sakura.crop(5, 339, 31, 46));
		sakuraJumpL[1] = ImageLoader.flip(sakura.crop(43, 339, 38, 49));


		////////////////////////////////////////
		sakuraWalkingLeft = new BufferedImage[6];

		sakuraWalkingLeft[0] = ImageLoader.flip(sakura.crop(8, 91, 30, 48));
		sakuraWalkingLeft[1] = ImageLoader.flip(sakura.crop(48, 91, 30, 48));
		sakuraWalkingLeft[2] = ImageLoader.flip(sakura.crop(87, 91, 30, 48));
		sakuraWalkingLeft[3] = ImageLoader.flip(sakura.crop(125, 91, 30, 48));
		sakuraWalkingLeft[4] = ImageLoader.flip(sakura.crop(165, 91, 30, 48));
		sakuraWalkingLeft[5] = ImageLoader.flip(sakura.crop(204, 91, 30, 48));

		///////////////////////////
		sakuraWalkingRight = new BufferedImage[6];

		sakuraWalkingRight[0] = sakura.crop(8, 91, 30, 48);
		sakuraWalkingRight[1] = sakura.crop(48, 91, 30, 48);
		sakuraWalkingRight[2] = sakura.crop(87, 91, 30, 48);
		sakuraWalkingRight[3] = sakura.crop(125, 91, 30, 48);
		sakuraWalkingRight[4] = sakura.crop(165, 91, 30, 48);
		sakuraWalkingRight[5] = sakura.crop(204, 91, 30, 48);

		////////////////////////////////
		sakuraRunningRight = new BufferedImage[6];

		sakuraRunningRight[0] = sakura.crop(3, 156, 43, 43);
		sakuraRunningRight[1] = sakura.crop(55, 155, 43, 43);
		sakuraRunningRight[2] = sakura.crop(113, 155, 43, 43);
		sakuraRunningRight[3] = sakura.crop(170, 155, 43, 43);
		sakuraRunningRight[4] = sakura.crop(224, 155, 43, 43);
		sakuraRunningRight[5] = sakura.crop(287, 153, 43, 43);

		////////////////////////////////
		sakuraRunningLeft = new BufferedImage[6];

		sakuraRunningLeft[0] = ImageLoader.flip(sakura.crop(3, 156, 43, 43));
		sakuraRunningLeft[1] = ImageLoader.flip(sakura.crop(55, 155, 43, 43));
		sakuraRunningLeft[2] = ImageLoader.flip(sakura.crop(113, 155, 43, 43));
		sakuraRunningLeft[3] = ImageLoader.flip(sakura.crop(170, 155, 43, 43));
		sakuraRunningLeft[4] = ImageLoader.flip(sakura.crop(224, 155, 43, 43));
		sakuraRunningLeft[5] = ImageLoader.flip(sakura.crop(287, 153, 43, 43));

		////////////////////
		sakuraStandingR = new BufferedImage[4];

		sakuraStandingR[0] = sakura.crop(3, 21, 30, 48);
		sakuraStandingR[1] = sakura.crop(40, 21, 30, 48);
		sakuraStandingR[2] = sakura.crop(78, 21, 30, 48);
		sakuraStandingR[3] = sakura.crop(115, 21, 30, 48);

		////////////////////
		sakuraStandingL = new BufferedImage[4];

		sakuraStandingL[0] = ImageLoader.flip(sakura.crop(3, 21, 30, 48));
		sakuraStandingL[1] = ImageLoader.flip(sakura.crop(40, 21, 30, 48));
		sakuraStandingL[2] = ImageLoader.flip(sakura.crop(78, 21, 30, 48));
		sakuraStandingL[3] = ImageLoader.flip(sakura.crop(115, 21, 30, 48));

		//*****************************Kakashi*************************************\\

		////////////////////////
		kakashiJumpR = new BufferedImage[2];

		kakashiJumpR[0] = kakashi.crop(6, 390, 38, 68);
		kakashiJumpR[1] = kakashi.crop(49, 390, 38, 68);

		////////////////////////
		kakashiJumpL = new BufferedImage[2];

		kakashiJumpL[0] = ImageLoader.flip(kakashi.crop(6, 390, 38, 68));
		kakashiJumpL[1] = ImageLoader.flip(kakashi.crop(49, 390, 38, 68));


		////////////////////////////////////////
		kakashiWalkingLeft = new BufferedImage[6];

		kakashiWalkingLeft[0] = ImageLoader.flip(kakashi.crop(2, 89, 34, 68));
		kakashiWalkingLeft[1] = ImageLoader.flip(kakashi.crop(38, 89, 34, 68));
		kakashiWalkingLeft[2] = ImageLoader.flip(kakashi.crop(74, 89, 34, 68));
		kakashiWalkingLeft[3] = ImageLoader.flip(kakashi.crop(110, 89, 34, 68));
		kakashiWalkingLeft[4] = ImageLoader.flip(kakashi.crop(146, 89, 34, 68));
		kakashiWalkingLeft[5] = ImageLoader.flip(kakashi.crop(182, 89, 34, 68));

		///////////////////////////
		kakashiWalkingRight = new BufferedImage[6];

		kakashiWalkingRight[0] = kakashi.crop(2, 89, 34, 68);
		kakashiWalkingRight[1] = kakashi.crop(38, 89, 34, 68);
		kakashiWalkingRight[2] = kakashi.crop(74, 89, 34, 68);
		kakashiWalkingRight[3] = kakashi.crop(110, 89, 34, 68);
		kakashiWalkingRight[4] = kakashi.crop(146, 89, 34, 68);
		kakashiWalkingRight[5] = kakashi.crop(182, 89, 34, 68);

		////////////////////////////////
		kakashiRunningRight = new BufferedImage[6];

		kakashiRunningRight[0] = kakashi.crop(3, 177, 60, 58);
		kakashiRunningRight[1] = kakashi.crop(93, 177, 45, 58);
		kakashiRunningRight[2] = kakashi.crop(164, 177, 52, 58);
		kakashiRunningRight[3] = kakashi.crop(237, 177, 54, 58);
		kakashiRunningRight[4] = kakashi.crop(321, 177, 50, 58);
		kakashiRunningRight[5] = kakashi.crop(395, 177, 52, 58);

		////////////////////////////////
		kakashiRunningLeft = new BufferedImage[6];

		kakashiRunningLeft[0] = ImageLoader.flip(kakashi.crop(3, 177, 60, 58));
		kakashiRunningLeft[1] = ImageLoader.flip(kakashi.crop(93, 177, 45, 58));
		kakashiRunningLeft[2] = ImageLoader.flip(kakashi.crop(164, 177, 52, 58));
		kakashiRunningLeft[3] = ImageLoader.flip(kakashi.crop(237, 177, 54, 58));
		kakashiRunningLeft[4] = ImageLoader.flip(kakashi.crop(321, 177, 50, 58));
		kakashiRunningLeft[5] = ImageLoader.flip(kakashi.crop(395, 177, 52, 58));

		////////////////////
		kakashiStandingR = new BufferedImage[3];

		kakashiStandingR[0] = kakashi.crop(10, 15, 48, 55);
		kakashiStandingR[1] = kakashi.crop(70, 15, 48, 55);
		kakashiStandingR[2] = kakashi.crop(130, 15, 48, 55);
		//kakashiStandingR[2] = kakashi.crop(190, 15, 30, 55);

		////////////////////
		kakashiStandingL = new BufferedImage[3];

		kakashiStandingL[0] = ImageLoader.flip(kakashi.crop(10, 15, 48, 55));
		kakashiStandingL[1] = ImageLoader.flip(kakashi.crop(70, 15, 48, 55));
		kakashiStandingL[2] = ImageLoader.flip(kakashi.crop(130, 15, 48, 55));
		//kakashiStandingL[2] = flip(kakashi.crop(190, 15, 30, 55));

		//*****************************Neji*************************************\\
		////////////////////////
		nejiJumpR = new BufferedImage[2];

		nejiJumpR[0] = neji.crop(2, 594, 39, 55);
		nejiJumpR[1] = neji.crop(43, 594, 39, 55);

		////////////////////////
		nejiJumpL = new BufferedImage[2];

		nejiJumpL[0] = ImageLoader.flip(neji.crop(2, 594, 39, 55));
		nejiJumpL[1] = ImageLoader.flip(neji.crop(43, 594, 39, 55));


		////////////////////////////////////////
		nejiWalkingLeft = new BufferedImage[6];

		nejiWalkingLeft[0] = ImageLoader.flip(neji.crop(8, 332, 22, 59));
		nejiWalkingLeft[1] = ImageLoader.flip(neji.crop(43, 332, 28, 59));
		nejiWalkingLeft[2] = ImageLoader.flip(neji.crop(83, 332, 28, 59));
		nejiWalkingLeft[3] = ImageLoader.flip(neji.crop(121, 332, 28, 59));
		nejiWalkingLeft[4] = ImageLoader.flip(neji.crop(161, 332, 28, 59));
		nejiWalkingLeft[5] = ImageLoader.flip(neji.crop(198, 332, 28, 59));

		///////////////////////////
		nejiWalkingRight = new BufferedImage[6];

		nejiWalkingRight[0] = neji.crop(8, 332, 22, 59);
		nejiWalkingRight[1] = neji.crop(43, 332, 28, 59);
		nejiWalkingRight[2] = neji.crop(83, 332, 28, 59);
		nejiWalkingRight[3] = neji.crop(121, 332, 28, 59);
		nejiWalkingRight[4] = neji.crop(161, 332, 28, 59);
		nejiWalkingRight[5] = neji.crop(198, 332, 28, 59);

		////////////////////////////////
		nejiRunningRight = new BufferedImage[6];

		nejiRunningRight[0] = neji.crop(3, 395, 54, 43);
		nejiRunningRight[1] = neji.crop(70, 394, 47, 43);
		nejiRunningRight[2] = neji.crop(128, 394, 47, 43);
		nejiRunningRight[3] = neji.crop(185, 394, 47, 43);
		nejiRunningRight[4] = neji.crop(247, 394, 47, 43);
		nejiRunningRight[5] = neji.crop(305, 394, 47, 43);

		////////////////////////////////
		nejiRunningLeft = new BufferedImage[6];

		nejiRunningLeft[0] = ImageLoader.flip(neji.crop(3, 395, 54, 43));
		nejiRunningLeft[1] = ImageLoader.flip(neji.crop(70, 394, 47, 43));
		nejiRunningLeft[2] = ImageLoader.flip(neji.crop(128, 394, 47, 43));
		nejiRunningLeft[3] = ImageLoader.flip(neji.crop(185, 394, 47, 43));
		nejiRunningLeft[4] = ImageLoader.flip(neji.crop(247, 394, 47, 43));
		nejiRunningLeft[5] = ImageLoader.flip(neji.crop(305, 394, 47, 43));

		////////////////////
		nejiStandingR = new BufferedImage[4];

		nejiStandingR[0] = neji.crop(5, 1260, 39, 54);
		nejiStandingR[1] = neji.crop(50, 1260, 39, 54);
		nejiStandingR[2] = neji.crop(97, 1260, 39, 54);
		nejiStandingR[3] = neji.crop(143, 1260, 39, 54);

		////////////////////
		nejiStandingL = new BufferedImage[4];

		nejiStandingL[0] = ImageLoader.flip(neji.crop(5, 1260, 39, 54));
		nejiStandingL[1] = ImageLoader.flip(neji.crop(50, 1260, 39, 54));
		nejiStandingL[2] = ImageLoader.flip(neji.crop(97, 1260, 39, 54));
		nejiStandingL[3] = ImageLoader.flip(neji.crop(143, 1260, 39, 54));


		//*****************************Shikamaru*************************************\\

		////////////////////////
		shikamaruJumpR = new BufferedImage[2];

		shikamaruJumpR[0] = shikamaru.crop(2, 382, 39, 58);
		shikamaruJumpR[1] = shikamaru.crop(46, 382, 39, 58);

		////////////////////////
		shikamaruJumpL = new BufferedImage[2];

		shikamaruJumpL[0] = ImageLoader.flip(shikamaru.crop(2, 382, 39, 58));
		shikamaruJumpL[1] = ImageLoader.flip(shikamaru.crop(46, 382, 39, 58));


		////////////////////////////////////////
		shikamaruWalkingLeft = new BufferedImage[6];

		shikamaruWalkingLeft[0] = ImageLoader.flip(shikamaru.crop(8, 99, 24, 58));
		shikamaruWalkingLeft[1] = ImageLoader.flip(shikamaru.crop(42, 99, 28, 58));
		shikamaruWalkingLeft[2] = ImageLoader.flip(shikamaru.crop(76, 99, 28, 58));
		shikamaruWalkingLeft[3] = ImageLoader.flip(shikamaru.crop(113, 99, 28, 58));
		shikamaruWalkingLeft[4] = ImageLoader.flip(shikamaru.crop(149, 99, 28, 58));
		shikamaruWalkingLeft[5] = ImageLoader.flip(shikamaru.crop(185, 99, 28, 58));

		///////////////////////////
		shikamaruWalkingRight = new BufferedImage[6];

		shikamaruWalkingRight[0] = shikamaru.crop(8, 99, 24, 58);
		shikamaruWalkingRight[1] = shikamaru.crop(42, 99, 28, 58);
		shikamaruWalkingRight[2] = shikamaru.crop(76, 99, 28, 58);
		shikamaruWalkingRight[3] = shikamaru.crop(113, 99, 28, 58);
		shikamaruWalkingRight[4] = shikamaru.crop(149, 99, 28, 58);
		shikamaruWalkingRight[5] = shikamaru.crop(185, 99, 28, 58);

		////////////////////////////////
		shikamaruRunningRight = new BufferedImage[6];

		shikamaruRunningRight[0] = shikamaru.crop(3, 175, 48, 52);
		shikamaruRunningRight[1] = shikamaru.crop(60, 175, 44, 52);
		shikamaruRunningRight[2] = shikamaru.crop(112, 175, 44, 52);
		shikamaruRunningRight[3] = shikamaru.crop(158, 175, 48, 52);
		shikamaruRunningRight[4] = shikamaru.crop(215, 175, 44, 52);
		shikamaruRunningRight[5] = shikamaru.crop(268, 175, 44, 52);

		////////////////////////////////
		shikamaruRunningLeft = new BufferedImage[6];

		shikamaruRunningLeft[0] = ImageLoader.flip(shikamaru.crop(3, 175, 48, 52));
		shikamaruRunningLeft[1] = ImageLoader.flip(shikamaru.crop(60, 175, 44, 52));
		shikamaruRunningLeft[2] = ImageLoader.flip(shikamaru.crop(112, 175, 44, 52));
		shikamaruRunningLeft[3] = ImageLoader.flip(shikamaru.crop(158, 175, 48, 52));
		shikamaruRunningLeft[4] = ImageLoader.flip(shikamaru.crop(215, 175, 44, 52));
		shikamaruRunningLeft[5] = ImageLoader.flip(shikamaru.crop(268, 175, 44, 52));

		////////////////////
		shikamaruStandingR = new BufferedImage[5];

		shikamaruStandingR[0] = shikamaru.crop(4, 19, 29, 58);
		shikamaruStandingR[1] = shikamaru.crop(40, 19, 29, 58);
		shikamaruStandingR[2] = shikamaru.crop(76, 19, 32, 58);
		shikamaruStandingR[3] = shikamaru.crop(112, 19, 32, 58);
		shikamaruStandingR[4] = shikamaru.crop(148, 19, 32, 58);

		////////////////////
		shikamaruStandingL = new BufferedImage[5];

		shikamaruStandingL[0] = ImageLoader.flip(shikamaru.crop(4, 19, 29, 58));
		shikamaruStandingL[1] = ImageLoader.flip(shikamaru.crop(40, 19, 29, 58));
		shikamaruStandingL[2] = ImageLoader.flip(shikamaru.crop(76, 19, 32, 58));
		shikamaruStandingL[3] = ImageLoader.flip(shikamaru.crop(112, 19, 32, 58));
		shikamaruStandingL[4] = ImageLoader.flip(shikamaru.crop(148, 19, 32, 58));

	}


}
