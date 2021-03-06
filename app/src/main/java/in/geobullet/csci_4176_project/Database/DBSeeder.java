package in.geobullet.csci_4176_project.Database;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import in.geobullet.csci_4176_project.Database.Classes.Board;
import in.geobullet.csci_4176_project.Database.Classes.BoardPosterPair;
import in.geobullet.csci_4176_project.Database.Classes.Poster;
import in.geobullet.csci_4176_project.Database.Classes.PosterType;
import in.geobullet.csci_4176_project.Database.Classes.User;
import in.geobullet.csci_4176_project.Shared.SessionData;


public class DBSeeder {

    public void seedDatabase(DatabaseHandler dbHandler) {

        User u1 = new User();

        u1.setFirstName("Johnny");
        u1.setLastName("B. Goode.");
        u1.setDisplayName("JBG");
        u1.setEmail("JBG@goody.com");
        u1.setPassword("YouGuessedIt");
        u1.setAdmin(true);


        int user1Id = dbHandler.addUser(u1);

        User currentUser = dbHandler.getUserById(user1Id);

        Log.i("Seeding", "Added user: " + currentUser.toString());


        Board b1 = new Board();

        Calendar c1 = Calendar.getInstance(); // current date
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.YEAR, 2018);

        b1.setCreated(c1.getTime());
        b1.setCreatedByUserId(currentUser.getId());
        b1.setName("Local Bulletin 1");
        b1.setExpirationDate(c2.getTime());
        b1.setRadiusInMeters(1000);
        b1.setLongitude(-63.5917);
        b1.setLatitude(44.6366);
        //add this to display board created by user ID
        b1.setCreatedByUserId(u1.getId());

        int board1Id = dbHandler.addBoard(b1);

        //Added boardId to SessionData class
        SessionData.boardId = board1Id;

        b1 = dbHandler.getBoardById(board1Id);

        Log.d("Seeding", "Added board: " + b1.toString());


        List<Poster> allPosters = new ArrayList<>();

        /*********** Begin add all posters ****************/

        String[] posterTitles = {
                "QueenPins Spring Fundraising Event"
                , "Entreprenurial Development Conference & Expo"
                , "Business Case Writing Training"
                , "Project Management Professional Certification Training"
                , "Benefits of Hiring Immigrants"
                , "Air Traffic Control"
                , "HOPSIN - Borderline Tour w/ TOKEN"
                , "Broadway Hits Dartmouth"
                , "Keloose Paint The Town!"
                , "Shokran Canada 2017"
                , "Artists of Dalhousie Exhibition Launch!"
                , "KAMP cabaret take-over"
                , "Spring Geequinox ~Version 4.0~"
                , "Learn to Meditate"
                , "IELTS Preparation"
        };

        PosterType[] posterTypes = {
                PosterType.Event, PosterType.Event, PosterType.Service, PosterType.Service,
                PosterType.Event, PosterType.Event, PosterType.Event, PosterType.Event,
                PosterType.Event, PosterType.Event, PosterType.Event, PosterType.Event,
                PosterType.Event, PosterType.Service, PosterType.Service
        };

        String[] posterAddresses = {
                "Brightwood Golf & Country Club 227 School St.",
                "World Trade Convention Centre 1800 Argyle St.",
                "Regus Halifax 1959 Upper Water St. #1301",
                "Regus Halifax 1959 Upper Water St. #1301",
                "Halifax Exhibition Centre 200 Prospect Rd.",
                "Grand Banker Bar & Grill 82 Montague St.",
                "Marquee/Seahorse Complex 2037 Gottingen St",
                "Grace United Church 70 King Street ",
                "843 Fall River Road",
                "Dalhousie Student Union 6136 University Avenue ",
                "6101 University Ave",
                "Kamphyre Studios 6070 Almon Street ",
                "Halifax Forum Windsor Street ",
                "1 Cedarbrae Ln",
                "1256 Barrington St"
        };

        String[] posterCities = {
                "Dartmouth", "Halifax", "Halifax", "Halifax", "Halifax",
                "Halifax", "Halifax", "Dartmouth", "Fall River", "Halifax",
                "Halifax", "Halifax", "Halifax", "Halifax", "Halifax"
        };

        String[] posterStateProvs = {
                "NS", "NS", "NS", "NS", "NS",
                "NS", "NS", "NS", "NS", "NS",
                "NS", "NS", "NS", "NS", "NS"
        };



        String[] posterDetails = {
                "Join us for 3 hours of high energy fun while we host three " +
                        "incredible speakers, showcase local businesses, and connect " +
                        "powerful women (and their supporters) to other powerful " +
                        "people within the community. All this while raising funds for " +
                        "Habitat for Humanity Nova Scotia!",

                "Join your peers at Atlantic Canada's #1 business conference, " +
                        "expo, and networking event of the year! EDCE was created " +
                        "to help new and seasoned entrepreneurs take charge of their " +
                        "business. Our 1.5-day event offers valuable insights and " +
                        "exclusive opportunities with over 20 in-depth sessions, " +
                        "workshops, and presentations from top industry experts. " +
                        "We couple this content with an interactive Small Business " +
                        "expo and 3 one-on-one networking events to give you " +
                        "everything you'll need to address the ever changing business " +
                        "landscapes.",

                "This one day program will introduce participants to the " +
                        "principles of developing an effective Business Case, within " +
                        "the context of an interactive course driven by a case study." +
                        "This workshop will provide participants with a working " +
                        "knowledge of the principles of writing an effective, " +
                        "comprehensive and compelling Business Case." +
                        "The course is driven by participation in a case study, " +
                        "promoting immediate workplace transference.",

                "The PMP signifies that you speak and understand the" +
                        " global language of project management and connects " +
                        "you to a community of professionals, organizations " +
                        "and experts worldwide. Become a PMP and become a " +
                        "project hero. This Course Provides everything you " +
                        "need to know to pass the PMP Exam and become a " +
                        "Certified Project Management professional.",

                "Process for employers to participate in the " +
                        "New Atlantic initiative programs and pathways " +
                        "to immigration.Increasing Cultural Diversity." +
                        "* Building the NS Economy." +
                        "* Increasing opportunity." +
                        "* Boosts Innovation" +
                        "FOR INFORMATION Contact US NOW" +
                        "(902) 880-2428" +
                        "info@ibtradeshow.com" +
                        "WWW.IBTRADESHOW.COM",

                "Air Traffic Control is coming back to play " +
                        "the Grand Banker in Lunenburg Nova Scotia. " +
                        "Air Traffic Control is a rock band with an " +
                        "alternative twist. The independent and " +
                        "self-managed three-piece originated as " +
                        "Madhat and earned three nominations for " +
                        "Alternative Recording of the Year by the " +
                        "East Coast Music Association.",

                "HOPSIN is finally coming to HALIFAX! " +
                        "With Millions of followers and hundreds" +
                        " of millions of views on his YouTube videos," +
                        " this guy is a Hip Hop legend who's only " +
                        "just getting started! This Canadian Tour " +
                        "will also feature TOKEN, who is being " +
                        "heralded as the next Eminem!",

                "Always wanted to experience the magic and " +
                        "music of Broadway, but couldn't get to New " +
                        "York? Dartmouth Choral Society has you " +
                        "covered! In its annual spring concert, DCS " +
                        "brings some of Broadway's best-known and " +
                        "best-loved hits to cool, choral life - right " +
                        "in your own backyard! For just $15, you " +
                        "can experience classics from Les Miserables, " +
                        "Cats, Rent, West Side Story, The Phantom of " +
                        "the Opera, and more!",

                "Come Join us for a fun night @ LWF Hall. We" +
                        "will be hosting a Paint the Town Fundraiser " +
                        "in support of KELOOSE. 2017 is our 40th Year" +
                        "and we want to make it a memorable year! ",

                "A Syrian cultural night put on by Syrian " +
                        "newcomers to give back to the community." +
                        "Experience authentic Syrian culture and " +
                        "traditions in this unique show with a " +
                        "classic live action play, a singing " +
                        "performance, delicious Syrian food, and " +
                        "an exciting dance of swords and shields. " +
                        "Written and performed by Syrian newcomers " +
                        "and students, this event will provide you " +
                        "with the best and most authentic experience " +
                        "of Syrian culture!",

                "The Artists of Dalhousie society is excited" +
                        "to launch their Inaugural Art Exhibition " +
                        "happening on Monday, April 3rd at 2:30 pm " +
                        "in the SUB. That's right, Dalhousie is " +
                        "getting its' own student and Dal/King's " +
                        "community Art Gallery on the walls of the " +
                        "SUB'S atrium and more! We are thrilled to " +
                        "be bringing more visual arts into the SUB!" +
                        "And that's where you incredible humans " +
                        "come in! We're putting out a call for " +
                        "submissions for students, alumni, faculty " +
                        "can submit artwork of their creation to us!",

                "Kamphyre studio is delighted to welcome " +
                        "the producers, directors and actors of " +
                        "an exciting new musical production, KAMP," +
                        "as hosts for the April edition of our " +
                        "Kamphyre Cabaret. colliding worlds and " +
                        "new faces within the Halifax arts " +
                        "community is sure to uplift and inspire " +
                        "anyone partaking or as guests at this " +
                        "event. This cabaret is a fundraiser we " +
                        "are thrilled to host which will support " +
                        "the financial undertaking of an artistic " +
                        "endeavour of this calibre.",

                "Come Join the fun as we gather once more " +
                        "for the MOST AFFORDABLE weekend of geeky " +
                        "goodness! Support your favorite clubs " +
                        "gathered here to fundraise for the year " +
                        "ahead! This years cohost clubs are JVPS " +
                        ",SCA, NERO ARMONIA,IKG,MHA,FRAG and of " +
                        "course Geeks Versus Nerds - back with " +
                        "mayhem and VIP party goodness. ",

                "In the struggle to meet the challenges of " +
                        "everyday living, the richness, beauty and " +
                        "sacredness of life often remain hidden in " +
                        "the shadows of the mundane.This retreat " +
                        "offers an opportunity to explore beneath " +
                        "the layers of ordinariness and enter the " +
                        "inner chambers of your being. Strengthen " +
                        "your foundation of self-respect, inner " +
                        "power and love that is the glue for your " +
                        "life. Discover the humility to offer your " +
                        "unique gift to the world. Enjoy a day of " +
                        "simple exercises, reflective time and " +
                        "guided meditations. Designed for the " +
                        "modern multi-tasking woman with an " +
                        "interest in practical spirituality.",

                "This two and a half hour intensive review " +
                        "session with an IELTS specialist will help " +
                        "you prepare for your upcoming IELTS test. " +
                        "Learn strategies to help you with your " +
                        "listening, reading and writing. Know what " +
                        "to expect when you take your test, and " +
                        "feel more confident. Ask questions and " +
                        "get feedback on all four parts of the test."
        };

        int[] posterStartDateYears = {
                2017, 2017, 2017, 2017,
                2017, 2017, 2017, 2017,
                2017, 2017, 2017, 2017,
                2017, 2017, 2017
        };

        int[] posterStartDateMonths = {
                Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL,
                Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.MARCH,
                Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL
        };

        int[] posterStartDateDays = {
                20, 28, 28, 10, 9,
                15, 30, 8, 29, 30,
                3, 7, 22, 22, 26
        };

        int[] posterStartDateHours = {
                14, 18, 9, 9, 14,
                22, 20, 19, 19, 18,
                14, 20, 11, 10, 17
        };

        int[] posterStartDateMinutes = {
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 30, 0,
                0, 0, 0
        };

        int[] posterEndDateYears = {
                2017, 2017, 2017, 2017,
                2017, 2017, 2017, 2017,
                2017, 2017, 2017, 2017,
                2017, 2017, 2017
        };

        int[] posterEndDateMonths = {
                Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL,
                Calendar.APRIL, Calendar.APRIL, Calendar.APRIL, Calendar.APRIL,
                Calendar.APRIL, Calendar.MARCH, Calendar.APRIL, Calendar.APRIL,
                Calendar.APRIL, Calendar.APRIL, Calendar.APRIL
        };

        int[] posterEndDateDays = {
                20, 28, 28, 13, 9,
                16, 30, 8, 29, 30,
                3, 8, 23, 22, 27
        };

        int[] posterEndDateHours = {
                17, 23, 17, 17, 23,
                23, 23, 22, 21, 21,
                16, 23, 18, 16, 19
        };

        int[] posterEndDateMinutes = {
                0, 0, 0, 0, 0,
                59, 0, 0, 30, 0,
                0, 59, 0, 0, 30
        };

        String[] posterCosts = {
                "$25-$45", "$167-$282", "$699-$899", "$1999-$2400", "FREE",
                "$30", "$30-$150", "$15", "$40", "$30-$250",
                "FREE", "$10-$15", "$5-$15", "FREE", "FREE"
        };

        for (int i = 0; i < 15; i++) {
            Poster poster = new Poster();

            Calendar pCal1 = Calendar.getInstance();
            poster.setCreated(pCal1.getTime());
            poster.setCreatedByUserId(currentUser.getId());

            poster.setTitle(posterTitles[i]);
            poster.setPosterType(posterTypes[i]);
            poster.setAddress(posterAddresses[i]);
            poster.setCity(posterCities[i]);
            poster.setStateProv(posterStateProvs[i]);
            poster.setDetails(posterDetails[i]);

            Calendar startDateCal1 = Calendar.getInstance();
            startDateCal1.set(Calendar.YEAR, posterStartDateYears[i]);
            startDateCal1.set(Calendar.MONTH, posterStartDateMonths[i]);
            startDateCal1.set(Calendar.DATE, posterStartDateDays[i]);
            startDateCal1.set(Calendar.HOUR_OF_DAY, posterStartDateHours[i]);
            startDateCal1.set(Calendar.MINUTE, posterStartDateMinutes[i]);
            startDateCal1.set(Calendar.SECOND, 0);

            Calendar endDateCal1 = Calendar.getInstance();
            endDateCal1.set(Calendar.YEAR, posterEndDateYears[i]);
            endDateCal1.set(Calendar.MONTH, posterEndDateMonths[i]);
            endDateCal1.set(Calendar.DATE, posterEndDateDays[i]);
            endDateCal1.set(Calendar.HOUR_OF_DAY, posterEndDateHours[i]);
            endDateCal1.set(Calendar.MINUTE, posterEndDateMinutes[i]);
            endDateCal1.set(Calendar.SECOND, 0);

            poster.setStartDate(startDateCal1.getTime());
            poster.setEndDate(endDateCal1.getTime());

            poster.setStartTime(startDateCal1.getTime());
            poster.setEndTime(endDateCal1.getTime());

            poster.setPhotoName("poster_" + (i + 1) + ".png");
            poster.setCost(posterCosts[i]);

            int posterId = dbHandler.addPoster(poster);

            poster = dbHandler.getPosterById(posterId);

            Log.d("Seeding", "Added poster " + (i + 1) + ": " + poster.toString());

            allPosters.add(poster);
        }

        /*********** End add all posters ****************/

        /*********** Begin all Board Poster Pairs (add all posters to board 1) ************/

        for (Poster p: allPosters) {

            BoardPosterPair bpp = new BoardPosterPair();

            bpp.setBoardId(board1Id);
            bpp.setPosterId(p.getId());

            int bppId = dbHandler.addBoardPosterPair(bpp);

            bpp = dbHandler.getBoardPosterPairById(bppId);

            Log.d("Seeding", "Added board poster pair: " + bpp.toString());
        }

        /*********** End all Board Poster Pairs ************/

    }
}
