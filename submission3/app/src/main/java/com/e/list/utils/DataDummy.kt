package com.e.list.utils

import com.e.list.BuildConfig
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.data.source.remote.response.MovieItem
import com.e.list.data.source.remote.response.TvShowItem

object DataDummy {
    fun generatedDummyMovie(): List<MovieItem> {
        val movies = ArrayList<MovieItem>()

        movies.add(
            MovieItem(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018",
                BuildConfig.IMG_URL+"wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"
            )
        )

        movies.add(
            MovieItem(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                BuildConfig.IMG_URL+"aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        movies.add(
            MovieItem(
                3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                BuildConfig.IMG_URL+"4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        movies.add(
            MovieItem(
                4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018 ",
                BuildConfig.IMG_URL+"xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpg"
            )
        )

        movies.add(
            MovieItem(
                5,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019",
                BuildConfig.IMG_URL+"XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )

        movies.add(
            MovieItem(
                6,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "11/21/2018",
                BuildConfig.IMG_URL+"7568G5PAdQweNfTiuwzlssOxueB.jpg"
            )
        )

        movies.add(
            MovieItem(
                7,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "01/18/2019",
                BuildConfig.IMG_URL+"ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )

        movies.add(
            MovieItem(
                8,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "01/09/2019",
                BuildConfig.IMG_URL+"h3KN24PrOheHVYs9ypuOIdFBEpX.jpg"
            )
        )

        movies.add(
            MovieItem(
                9,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                BuildConfig.IMG_URL+"kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg"
            )
        )

        movies.add(
            MovieItem(
                10,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "12/14/2018",
                BuildConfig.IMG_URL+"gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )

        return movies
    }

    fun generatedDummyMovieEntity(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018",
                BuildConfig.IMG_URL+"wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                BuildConfig.IMG_URL+"aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                BuildConfig.IMG_URL+"4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018 ",
                BuildConfig.IMG_URL+"xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019",
                BuildConfig.IMG_URL+"XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "6",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "11/21/2018",
                BuildConfig.IMG_URL+"7568G5PAdQweNfTiuwzlssOxueB.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "7",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "01/18/2019",
                BuildConfig.IMG_URL+"ngBFDOsx13sFXiMweDoL54XYknR.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "8",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "01/09/2019",
                BuildConfig.IMG_URL+"h3KN24PrOheHVYs9ypuOIdFBEpX.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "9",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                BuildConfig.IMG_URL+"kbGO5mHPK7rh516MgAIJUQ9RvqD.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "10",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "12/14/2018",
                BuildConfig.IMG_URL+"gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"
            )
        )

        return movies
    }

    fun generatedDummyTvShow(): List<TvShowItem> {
        var tvShows = ArrayList<TvShowItem>()

        tvShows.add(
            TvShowItem(
                1,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "01/31/1999",
                BuildConfig.IMG_URL+"eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                2,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "03/28/2019",
                BuildConfig.IMG_URL+"iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                3,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "09/23/2003",
                BuildConfig.IMG_URL+"fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                4,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "01/26/2017",
                BuildConfig.IMG_URL+"wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                5,
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "01/9/2011",
                BuildConfig.IMG_URL+"9akij7PqZ1g6zl42DQQTtL9CTSb.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                6,
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "10/26/2015",
                BuildConfig.IMG_URL+"zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                7,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "09/13/2015",
                BuildConfig.IMG_URL+"KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                8,
                "The Simpsons ",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "12/17/1989",
                BuildConfig.IMG_URL+"zLudbPueg8CxGhMS2tyDh3p0TdK.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                9,
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "02/15/2019",
                BuildConfig.IMG_URL+"scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
            )
        )

        tvShows.add(
            TvShowItem(
                10,
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "10/31/2010",
                BuildConfig.IMG_URL+"rqeYMLryjcawh2JeRpCVUDXYM5b.jpg"
            )
        )

        return tvShows
    }

    fun generatedDummyTvShowEntity(): List<TvShowEntity> {
        var tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                "1",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "01/31/1999",
                BuildConfig.IMG_URL+"eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "2",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "03/28/2019",
                BuildConfig.IMG_URL+"iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "3",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "09/23/2003",
                BuildConfig.IMG_URL+"fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "4",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "01/26/2017",
                BuildConfig.IMG_URL+"wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "5",
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "01/9/2011",
                BuildConfig.IMG_URL+"9akij7PqZ1g6zl42DQQTtL9CTSb.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "6",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "10/26/2015",
                BuildConfig.IMG_URL+"zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "7",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "09/13/2015",
                BuildConfig.IMG_URL+"KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "8",
                "The Simpsons ",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "12/17/1989",
                BuildConfig.IMG_URL+"zLudbPueg8CxGhMS2tyDh3p0TdK.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "9",
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "02/15/2019",
                BuildConfig.IMG_URL+"scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "10",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "10/31/2010",
                BuildConfig.IMG_URL+"rqeYMLryjcawh2JeRpCVUDXYM5b.jpg"
            )
        )

        return tvShows
    }
}