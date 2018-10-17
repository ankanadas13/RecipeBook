-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 17 Okt 2018 pada 08.20
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 7.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recipebook`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `idadmin` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `status` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`idadmin`, `username`, `password`, `fullname`, `email`, `status`) VALUES
(15, 'root1', '12345', 'Hemorna Bernad', 'HemornaBernad@recipebook.com', 'Aktif'),
(16, 'root2', 'root2', 'Charly Jim', 'CharlyJim@recipebook.com', 'Aktif'),
(17, 'gavin', 'gavin', 'Richard Gavin', 'RichardGavin@recipebook.com', 'Aktif'),
(18, 'root4', 'root4', 'Charly Torvalds', 'CharlyTorvalds@recipebook.com', 'Aktif'),
(19, 'root5', 'gils', 'Hillary Queen', 'HillaryQueen@recipebook.com', 'Tidak Aktif'),
(20, 'root6', 'root6', 'Jimmy Bernad', 'JimmyBernad@recipebook.com', 'Aktif'),
(22, 'stevegrock', 'galiterus', 'Steve Grock', 'SteveGrock@recipebook.com', 'Aktif'),
(23, 'root9', 'root9', 'Charly Bernad', 'CharlyBernad@recipebook.com', 'Aktif'),
(24, 'root10', 'root10', 'Jimmy Gavin', 'JimmyGavin@recipebook.com', 'Aktif');

-- --------------------------------------------------------

--
-- Struktur dari tabel `recipe`
--

CREATE TABLE `recipe` (
  `idrecipe` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `ingredients` text NOT NULL,
  `directions` text NOT NULL,
  `time` varchar(200) NOT NULL,
  `difficulty` int(11) NOT NULL,
  `servings` int(11) NOT NULL,
  `category` varchar(100) NOT NULL,
  `imgpath` varchar(300) NOT NULL,
  `idadmin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `recipe`
--

INSERT INTO `recipe` (`idrecipe`, `name`, `ingredients`, `directions`, `time`, `difficulty`, `servings`, `category`, `imgpath`, `idadmin`) VALUES
(6, 'Chicken Porridge', '1/2 kg of rice (wash thoroughly)\r\n2 Glasses of chicken stock\r\n2 Cups of water\r\n1 Salt\r\n1/4 chicken (boneless)\r\n1 Fried onions\r\n1 Salty or sweet soy sauce\r\n1 Scallion (small slice)\r\n1 stem of celery leaves (small slices)\r\n1 Egg (boiled, peeled into two pieces)\r\n1 Powdered chicken broth (if you like, to taste)\r\n1 Bowl of Sambal (if you like)\r\n', 'Cook the rice with a water and chicken broth. Then, give salt and chicken stock. Cook the rice until it becomes soft and tender until cooked for about half an hour.\r\nNext, seasoning the chicken with salt then fry until cooked and sliced thinly.\r\nTake the bowl and place the chicken porridge on it. Sprinkle fried chicken meat, fried onions, spring onions, celery leaves and eggs.\r\nAdd soy sauce or sweet soy sauce on it. Add sambal too if you like.\r\n', '30 Minutes', 2, 2, 'Breakfast', 'images\\chicken.jpg', 16),
(7, 'Sour Soup', '1 piece of sweet corn.\r\n20 items of melinjo.\r\n1 cabbage.\r\n5 long beans.\r\n3 Beans.\r\n2 bay leaves.\r\n2 tablespoons of brown sugar.\r\n1 galangal finger segment.', 'The first step is to mix the vegetables to be mixed, then wash thoroughly.\r\nThen prepare the layah and seasoning until smooth.\r\nNext prepare a pan for cooking. Fill the water and bring to a boil, then add the spices, then the ingredients. Cover and cook over medium heat.\r\nAfterwards, taste the taste, add spices which according to recipe friends are lacking.\r\nLift serve.\r\n', '23 minutes', 3, 1, 'Breakfast', 'images\\hot.jpg', 18),
(8, 'Cow Beef Rendang', '500 grams of beef, cut into 12 parts\r\n900 ml of water\r\n3 packs of coconut milk\r\n1 turmeric leaf\r\n1 stalk of lemongrass\r\n3 points of candlenut acid\r\n1 oil to saute seasoning\r\n7 large red chilies\r\n7 pieces of curly red chili\r\n6 onion grains\r\n4 cloves garlic\r\n3 cm turmeric\r\n4 cm ginger\r\n5 cm galangal\r\n1 tablespoon of salt\r\n\r\n', 'Saute the spices until smooth, add the beef. \r\nStir and cook over medium heat until the meat changes color and then enter the kandis acid, turmeric leaves, lemongrass and mix well.\r\nPour water and coconut milk, cook and stir occasionally so that the coconut milk does not break, continue cooking until the water shrinks and reduce the heat while stirring constantly. \r\nLift after seasoning thickens and remove oil from coconut milk and tender meat then ready to be served.\r\n', '3 Hours', 4, 7, 'Spicy', 'images\\rendang-padang-eb4ec744695cded3ef334087e4a33d5f_600x400.jpg', 16),
(9, 'Shrimp Fritters ', '300 grams of peeled shrimp\r\n100 grams of rice flour\r\n200 ml of water\r\n1 bottle of oil\r\n3 onion grains\r\n1 teaspoon of cilantro\r\n1 segment of turmeric finger\r\n1 ginger finger segment\r\n1 galangal finger segment\r\n2 teaspoon salt\r\n\r\n', 'Cut the back then set it aside\r\nMix the rice flour with all the spices of water and mix well\r\nAdd the shrimp to take a spoonful of batter after a spoonful of fried until cooked up and drain for 3 servings.\r\n', '45 Minutes', 2, 5, 'Seafood', 'images\\2.jpeg', 17),
(10, 'Potato Patty ', '2 cup mashed potato day-old\r\n1 large egg beaten\r\n1/4 cup parsley chopped\r\n1/2 cup fresh breadcrumbs\r\n1 onion medium finely chopped\r\n1/2 cup edam cheese grated\r\n1/4 cup canola oil\r\n1/4 cup plain flour\r\n', 'In a large bowl, combine mashed potato, onion and parsley.\r\nAdd grated cheese.\r\nAdd egg to bind, add flour and mix well.\r\nPlace the breadcrumbs on a chopping board.\r\nForm potato into golf ball sized balls, fatten slightly and roll in breadcrumbs.\r\nHeat oil in a large fry-pan.\r\nFry potato patties on both sides until golden.\r\nKeep warm until ready to serve.\r\n', '30 Minutes', 3, 4, 'Snacks', 'images\\9.jpg', 17),
(11, 'Seared Strip Steak', '2 (12-ounce) lean, grass-fed New York strip steaks \r\n1 teaspoon kosher salt \r\n3/4 teaspoon black pepper \r\n1 tablespoon olive oil \r\n2 tablespoons butter \r\n2 thyme sprigs \r\n2 garlic cloves, crushed', 'Let steaks stand 30 minutes at room temperature.\r\nSprinkle salt and pepper evenly over steaks.\r\nHeat a large cast-iron skillet over high heat. \r\nAdd oil to pan; swirl to coat. Add steaks to pan; cook 3 minutes on each side or until browned. \r\nReduce heat to medium-low; add butter, thyme, and garlic to pan. Carefully grasp pan handle using an oven mitt or folded dish towel. \r\nTilt pan toward you so butter pools; cook 1 1/2 minutes, basting steaks with butter constantly. \r\nRemove steaks from pan; cover loosely with foil. Let stand 10 minutes. Reserve butter mixture.\r\nCut steak diagonally across grain into thin slices. Discard thyme and garlic; spoon reserved butter mixture over steak.', '1 Hour', 5, 6, 'Meat', 'images\\10.jpg', 18),
(13, 'Sumsum Porridge', '200 grams of rice flour\r\n1 ½ tsp salt\r\n1 liter of fresh coconut milk\r\n5 pandan leaves\r\n300 grams of Javanese sugar or brown sugar\r\n3 ginger fruits\r\n150 ml of water', 'Mix 200 grams of rice flour, 1½ teaspoons of salt, and 500 ml of fresh coconut milk.\r\nMix until mixed.\r\nAdd the remaining 500 ml of fresh coconut milk in a pan, heat it.\r\nAdd 2 pandan leaves.\r\nTake about 5 minutes.\r\nPour the rice flour mixture into the pan and stir.\r\nStir the mixture until the rice flour thickens and small bubbles appear.\r\nCook water in a different container.\r\nCut the brown sugar into pieces to make it easier to melt.\r\nCut the ginger, press it so that it comes out a little water.\r\nPut in a mixture of brown sugar.\r\nAdd the remaining pandan leaves.\r\nLet the brown sugar dissolve evenly.\r\nDrain brown sugar.\r\nTake the marrow porridge in a clean container and pour the brown sugar sauce', '30 minutes', 3, 3, 'Breakfast', 'images\\sumsum.jpg', 16),
(14, 'Sego sauce smoked fish', '4 pieces of smoked fish\r\n1 tempe slices\r\n1 tablespoon of salt\r\n1 coriander\r\n3 garlic cloves\r\n200 ml of water\r\n3 cloves of garlic fried\r\n3 fried red onion cloves\r\n3 cayenne pepper\r\n3 cloves of garlic fried\r\n3 fried red onion cloves\r\n3 cayenne pepper\r\n1 shrimp paste\r\n1 teaspoon of salt\r\n1 tomato fried', 'For the fish to run out, just fry it until it is browned, drain.\r\nFor tempeh, put all ingredients in 1 tempered 5-minute bath bowl, fried until cooked, drain.\r\nFor sambal, all ingredients make sure that the onion, white and tomatoes are fried. Then heat cooking oil after hot oil pour into the sauce. Then set the tempeh in chili ready to be eaten with warm rice without queuing', '10 minutes', 4, 3, 'Spicy', 'images\\r.jpg', 16),
(15, 'Liwet Teri Rice', '8 fine red onion slices\r\n5 garlic cloves\r\n3 pcs of red curly chili \r\n3 pcs green curly chillies \r\n5 bay leaf\r\n3 lemongrass stems\r\n4 cups of rice\r\n1 fried anchovies \r\n1 fried onions\r\n2 teaspoon salt ', 'Wash the rice. Put it in a rice cooker. Give water like cooking rice, add salt to taste.\r\nCut the onion, chili, salam, lemongrass until wilted and fragrant. \r\nAdd the stir fry to the rice cooker.\r\nAdd some anchovies to the rice. Turn on the rice cooker.\r\nAfter the rice is cooked, serve the rice sprinkled with fried onions and anchovies.', '14 minutes', 2, 3, 'Breakfast', 'images\\li.jpg', 15),
(16, 'Seafood Soup ', '1.5 liters of air or broth\r\n200 grams of shrimp, peeled and then cut into small pieces\r\n200 grams of squid, clean and then cut into small pieces\r\n20 grams of ear mushrooms, soak in water until wilted, slice long\r\n1 peeled carrot and sliced long leaves\r\n1 egg\r\n3 cloves of garlic\r\n2-3 tablespoons of fish sauce\r\n½ tsp pepper powder\r\n1 tsp salt\r\n2 tsp sugar\r\n1½ tablespoons of cornstarch, dissolve with 1 tablespoon of water\r\n4 teaspoon of oil', 'Heat a little cooking oil then cut the garlic.\r\nAdd the shrimp, squid, mushrooms and carrots, stir for a while.\r\nAdd water or broth, fish sauce, pepper powder, salt and sugar, mix well and boil.\r\nAdd the cornstarch mixture that has been stirred with water, stirring for a while until it thickens. Then enter the egg and stir for a while. ', '18 minutes', 4, 5, 'Seafood', 'images\\00.jpg', 18),
(17, 'Kalio Squid Soup', '1 kg of medium size squid\r\n1 liter of coconut milk from 1½ coconuts\r\n2 segment of thumb, scalp, scar\r\n1 segment of the ginger thumb, grated\r\n2 seeds of kandis acid\r\n5 dried red chilies\r\n10 onion grains\r\n5 garlic cloves\r\n5 roasted pecan\r\n1 tablespoon coriander roasted\r\n1 teaspoom cumin roasted\r\n2 grilled turmeric fingers\r\n1 teaspoon of salt', 'Put the head into the squid''s body, then pin the tip of the squid''s body with a toothpick.\r\nMix the spices with coconut milk and other spices, then cook while stirring slowly until boiling.\r\nReduce the heat, continue cooking until the seasoning is cooked and coconut milk \r\nAdd the squid, cook until the squid is cooked and the spices soak. Lift.', '11 Minutes', 1, 2, 'Seafood', 'images\\kalio.jpg', 18),
(18, 'Fish Soup', '2 snapper, cut each into 3 parts\r\n10 star fruit\r\n50 grams of basil leaves\r\n800 ml of water\r\n3 grains of garlic\r\n3 red chilies\r\n2 cm ginger\r\n1 cm of turmeric\r\n1 tablespoon of salt\r\n1 lemongrass stick, spread\r\n2 orange leaves\r\n1 tomato, slice the dice', 'Bring a boil of water, add finely ground spices, lemongrass, orange leaves and fish. Cook it.\r\nAdd tomatoes, star fruit and basil leaves. Cook until the basil leaves wither.', '4 minutes', 2, 1, 'Breakfast', 'images\\sp.jpg', 16),
(19, 'Cobo Garo Rica', '1 tuna (800 grams), clean and cut into pieces\r\n2 tbsp lime juice + 1/2 tsp salt\r\n4 orange leaves\r\n4 tablespoons of oil, to saute\r\n10 onions, roughly sliced\r\n10 onion grains\r\n10-15 red curly chilies\r\n5 garlic cloves\r\n1 ginger knuckle, grated\r\n1 teaspoon salt', 'Wash the tuna, coat with lime juice and salt, spread and let stand for 30 minutes.\r\nThen, heat the oil in a non-stick pan, cut the sliced onion, finely ground and lime leaves.\r\nAdd a glass of hot water stir until boiling.\r\nPut the fish in. Add back a glass of hot water, cook over low heat while occasionally \r\nTurning it until the fish is evenly cooked and the spices soak. Lift and serve.', '6 minutes', 1, 3, 'Seafood', 'images\\rica.jpg', 17),
(20, 'Balado Egg ', '10 chicken eggs\r\n5 onions\r\n5 garlic\r\n20 red curly chilies\r\n1 pecan\r\n1 tomato\r\n3/4 tsp salt\r\n½ tsp pepper\r\n1 pete board\r\n1 teaspoon flavoring seasoning\r\n100 ml of water\r\n1 teaspoon of oil', 'Boil chicken eggs.\r\nOpen and clean the banana.\r\nLift and soak in cold water. Let stand for 5 minutes.\r\nPeel the chicken eggshells and drain.\r\nBoil chicken eggs.\r\nOpen and clean the banana.\r\nLift and soak in cold water. Let stand for 5 minutes.\r\nPeel the chicken eggshells and drain.\r\nBlend the whole seasoning. Mix with salt, pepper and flavoring if used.\r\nAdd enough cooking oil, cook the peeled eggs until the color is a little brown.\r\nFried pete separately.\r\nCut into the spices that are mashed until fragrant.\r\nPut the fried eggs and bananas. Stir well.', '15 minutes', 1, 8, 'Spicy', 'images\\egg.jpg', 16),
(21, 'Betutu Duck', '2 kg of duck\r\n16 chopped onion cloves\r\n8 garlic cloves\r\n2 tablespoons of cilantro\r\n1 tsp nutmeg\r\n10 seeds of red Lombok\r\n10 pieces of cayenne pepper\r\n2 tsp dry paste\r\n10 roasted pecan\r\n1 thumb chopped ginger\r\n3 chopped laos thumbs\r\n1 thumb kencur\r\n3 thumbs chopped turmeric\r\n5 The white lemongrass stems\r\n5 bay leaves\r\n5 orange leaves\r\n2 packs of coconut milk and add 500 ml of water', 'Rinse and rinse with salt and lime juice, let stand 15-20 minutes then Rinse again with water.\r\nHeat the pan to fry all cooking ingredients until fragrant.\r\nPut the duck stir until evenly mixed and give half coconut milk to give salt, sugar, pepper, flavoring.\r\nAdd the remaining coconut milk\r\nPreheat the oven to 160 and bake for 30 minutes then take aluminimun foil. Let stand for 30 minutes.', '19 minutes', 4, 9, 'Spicy', 'images\\betutu.jpg', 16),
(22, 'Spicy Claw', '500 gr fresh chicken claw\r\n7 cloves of garlic\r\n7 red onion cloves\r\n1 teaspoon salt\r\n½ teaspoon pepper\r\n2 bay leaves\r\n1 finger segment of ginger\r\n5 pieces of cayenne pepper\r\n8 red chilies', 'Wash the chicken claw\r\nPour water and heat\r\nAdd chicken claw\r\nPeel ginger and spread.\r\nAdd bay leaves, salt and ginger.\r\nCook until it''s tender.\r\nBlend the garlic, onion, cayenne pepper and red chili.\r\nHeat the oil in a frying pan over medium heat, stir-fry the seasoned spices. \r\nAdd the tender chicken claw to the stir fry.\r\nCook on low heat. Mix well.', '13 minutes', 4, 1, 'Spicy', 'images\\cl.jpg', 16),
(23, 'Stir Fry Spinach Tofu ', '1 bunch of spinach (if the supermarket is usually bagged)\r\n1 local carrot is cut thin - microwave for 2 minutes\r\n1 tofu white (large) diced, fried first\r\n3 tablespoons of sesame oil', 'Heat sesame oil in a pan\r\nPut all ingredients (except sesame), stir-fry until spinach withers\r\nServe with sesame sprinkles.\r\n', '5 Minutes', 2, 3, 'Vegetarian', 'images\\tofu.jpg', 17),
(24, 'Mashed Cauliflower', '1 small piece of cauliflower\r\n1 tablespoon light olive oil\r\n1 clove of garlic\r\n1 tablespoon nutritional yeast\r\n1 Sea salt\r\n1 Black pepper\r\n1 Dried herbs', 'Boil / steam cauliflower in boiling water until cooked. Then, slice it off.\r\nStir fry garlic until fragrant, remove, add nutritional yeast, herbs, pepper, and salt\r\nAdd cooked cauliflower and puree it all with immersion blender / potato masher', '20 minutes', 2, 3, 'Vegetarian', 'images\\3.jpeg', 17),
(25, 'Lemet', '50 grams of grated cassava, squeeze, defecate\r\n25 ml of water\r\n150 grams of coarse grated coconut\r\n½ teaspoon of salt\r\n100 grams of sugar\r\n6 Banana leaves to wrap / mold', 'Mix cassava, water, grated coconut, salt and sugar\r\nTake banana / mold leaves, give the dough, wrap, fold left and right\r\nSteam for 30 minutes over medium heat until cooked, remove\r\nServe the food', '15 minutes', 3, 4, 'Snacks', 'images\\lemet1.jpg', 18),
(26, 'Wajik Brown Sugar', '600 grams of solo glutinous rice\r\n100 ml of cold water\r\n250 ml coconut milk\r\n300 grams of brown sugar\r\n2 tablespoons of sugar\r\n1/2 tsp salt\r\n2 pandan leaves\r\n3 orange leaves', 'Soak the sticky rice 3/4 hour\r\nAfter soaking wash it and steaming 20 minutes, after all half-cooked sticky rice. let it stay steamed \r\nThen pour a little cold water and stir, the aim is to make the sticky rice a little stretchy. Then steam it approximately 10 minutes.\r\nBoil over low brown sugar. sand. pandan leaves. orange leaves. salt. boil and strain until it is rather hairy\r\nThen put the sticky rice and stir, until the sugar water seeps greasy and oily\r\n', '20 minutes', 3, 6, 'Snacks', 'images\\wa.jpg', 17),
(27, 'Bites Koko Crunch', '1 chocolate bar\r\n1 tablespoon of white butter\r\n1 cup of small paper for cookies\r\n1 box of Koko Krunch to taste\r\n1 sprinkle pack', 'Put the chocolate and white butter on a pan filled with hot water.\r\nAfter the chocolate has melted completely, lift it and wait until it''s cool, stir well.\r\nAfter a little cold, enter Koko Krunch, mix well until all is coated with chocolate.\r\nPlace it on the cup, sprinkle the sprinkle on it enough.\r\n', '10 minutes', 3, 8, 'Snacks', 'images\\21.jpg', 16),
(28, 'Fried Meatballs ', '150 grams of beef, chopped\r\n½ teaspoon of salt\r\n2 teaspoon pepper powder\r\n½ egg\r\n½ beaten eggs\r\n2 tablespoons of cooking oil\r\n1 tomato, grated\r\n2 cm galangal, curly\r\n2 bay leaves\r\n2 orange leaves\r\n½ teaspoon of salt\r\n½ tsp sugar\r\n½ cup of coconut milk from ¼ coconuts\r\n50 grams of young coconut, grated, roasted, and pureed\r\n2 cloves of garlic\r\n2 red chilies', 'Mix the meat with salt, pepper and eggs, mix well. Mix it and dip it into a beaten egg.\r\nHeat cooking oil, enter meat balls one by one. Stir and cook until it changes color.\r\nAdd spices, tomatoes, galangal, bay leaves, orange leaves, salt, and sugar, pour coconut milk. Mix well and cook until boiling. Add the sangria coconut, stir well. Cook briefly until boiling. Lift.', '8 minutes', 2, 3, 'Meat', 'images\\de.jpg', 15),
(29, 'Java beefsteak', '150 grams of meat, thinly sliced\r\n1 tablespoon of English soy sauce\r\n½ teaspoon of salt\r\n½ teaspoon of salt\r\n½ tsp pepper powder\r\n1 tsp sugar\r\n1 tablespoon of starch\r\n2 tablespoons of butter\r\n2 cloves of garlic, sliced\r\n1 Bombay onion, sliced\r\n2 tbsp tomato sauce\r\n½ cup of water\r\n500 ml Cooking oil\r\n1 ½ cm thick cut potato and soak water\r\n1 carrot, cut 3 cm x 1/2 cm\r\n50 grams of beans, cut 3 cm', 'Mix meat with English soy sauce, salt, pepper, nutmeg, sugar, and starch, mix well\r\nHeat butter in a non-stick skillet, sauté garlic and onions until wilted\r\nAdd the meat a little to the sautéed pan, stirring occasionally\r\nAdd the stir-fried onion, tomato sauce, and water, cook until the sauce is boiling\r\nHeat oil, fry potatoes until yellowish. Boil carrots and beans until cooked\r\nServe the steak with a complement of French fries, carrots and beans', '13 minutes', 3, 1, 'Meat', 'images\\si.jpg', 16),
(30, 'Meat Tomato Roll Sauce', '2 tablespoons of butter\r\n2 cloves of garlic, chopped\r\n1 onion, chopped\r\n1 tablespoon of red chili, sliced\r\n150 grams of meat, thinly sliced and rolled\r\n1 tablespoon tomato sauce\r\n3 tomatoes, grated\r\n½ teaspoon of salt\r\n½ tsp sugar\r\n1 tsp pepper powder\r\n1 tsp English soy sauce\r\n½ tsp nutmeg powder\r\n½ cup of water', 'Heat butter, saute garlic and onion until fragrant. Add red chili, stir until wilted\r\nAdd meat rolls, tomato sauce, grated tomatoes, salt, sugar, pepper, Soy sauce, and nutmeg\r\nThen, stirring slowly\r\nPour water, stir and cook until the spices soak and the meat is cooked. Serve while hot\r\n', '18 minutes', 3, 4, 'Meat', 'images\\enak.jpg', 17);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idadmin`);

--
-- Indexes for table `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`idrecipe`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idadmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `recipe`
--
ALTER TABLE `recipe`
  MODIFY `idrecipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
