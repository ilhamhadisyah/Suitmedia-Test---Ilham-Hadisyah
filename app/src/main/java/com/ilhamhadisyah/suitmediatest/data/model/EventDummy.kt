package com.ilhamhadisyah.suitmediatest.data.model

object EventDummy {
    private val eventList: ArrayList<EventModel> = arrayListOf()

    private fun populateData() {
        eventList.add(
            EventModel(
                1,
                "Tech in Asia",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F303301719%2F759600762633%2F1%2Foriginal.20220615-094552?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C0%2C2160%2C1080&s=bd2c997a5a60700670fed317c32d3509",
                "Fintech Forum",
                -7.948536, 112.616754,
                "Thu, Jul 7, 2022",
                "1:00 PM"
            )
        )

        eventList.add(
            EventModel(
                2,
                "Spanish Startups",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F295128589%2F255319539082%2F1%2Foriginal.20220601-083526?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C0%2C2160%2C1080&s=8d89cde343e8912ad7bba482d87dd9ed",
                "#HackSTEM22: Disruptive Technologies and Math: A Success Story?",
                -7.949174, 112.613289,
                "Wed, Jun 22, 2022",
                "10:30 PM"
            )
        )

        eventList.add(
            EventModel(
                3,
                "The Human Rights, Big Data and Technology Project",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F305077569%2F255170785042%2F1%2Foriginal.20220618-091948?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=452%2C0%2C1000%2C500&s=a74f53a987268ad64f23797b62963ec8",
                "Human Rights and Emerging Technologies",
                -7.946898, 112.618330,
                "Tue, Jun 21, 2022",
                "5:30 PM"
            )
        )
        eventList.add(
            EventModel(
                4,
                "NCAR Lectures & Events",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F286237919%2F161166563680%2F1%2Foriginal.20220517-143851?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C0%2C2048%2C1024&s=247d7ab43da21b7f7554da9411325f50",
                "How emerging technologies can enable us to create an inclusive future",
                -7.923247, 112.602169,
                "Thu, Jun 30, 2022",
                "8:00 AM"
            )
        )
        eventList.add(
            EventModel(
                5,
                "OpenGov Asia",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F251227039%2F686361592213%2F1%2Foriginal.20220321-091828?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C236%2C5000%2C2500&s=26670cb5267782cf786af7b238a1cf94",
                "Cloud Technology’s Vital Role in the Philippines’ Evolving Pedagogy",
                -7.923789, 112.597341,
                "Tue, Jun 28, 2022",
                "7:45 AM"
            )
        )
        eventList.add(
            EventModel(
                6,
                "MRANTI",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F295103219%2F858795730643%2F1%2Foriginal.20220601-071504?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C539%2C5760%2C2880&s=5e7d4e911be7cff7d9dc03aa1c13b06c",
                "How 5G Technology Impacts Future of Businesses",
                -7.926853, 112.594920,
                "Thu, Jul 7, 2022",
                "9:00 AM"
            )
        )
        eventList.add(
            EventModel(
                7,
                "HITLAB",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F300984469%2F699697111953%2F1%2Foriginal.20220610-183117?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C0%2C2160%2C1080&s=bf17050f2b63760dafc2aae0b66c1e7b",
                "HITLAB Summer Summit 2022",
                -7.927628, 112.599952,
                "Thu, Jun 30, 2022",
                "8:00 PM"
            )
        )

        eventList.add(
            EventModel(
                8,
                "Washington DC Quantum Computing Meetup",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F277295509%2F299882633329%2F1%2Foriginal.20220503-013155?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C93%2C2560%2C1280&s=7d8b07ef9138bcd319411ddc25122646",
                "QiWi- A Quantum Programming Language",
                -7.966040, 112.633808,
                "Sun, Aug 7, 2022",
                "9:00 PM"
            )
        )

        eventList.add(
            EventModel(
                9,
                "EngBio IRC",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F293788759%2F114401964019%2F1%2Foriginal.20220530-094709?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C0%2C1372%2C686&s=34a6f8bb67523cfca034e460613864c6",
                "No-Code Programming for Biology 2022",
                -7.964521, 112.630225,
                "Mon, Jun 27, 2022",
                "11:30 PM"
            )
        )
        eventList.add(
            EventModel(
                10,
                "Le Wagon Barcelona",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F289740759%2F136125000243%2F1%2Foriginal.20220523-154057?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C58%2C3200%2C1600&s=f8ae3ff84d1046b9bca1c8d78307598c",
                "Online workshop: Learn the fundamentals of programming in just 2 hours",
                -7.966190, 112.626423,
                "Tue, Jun 21, 2022",
                "11:30 PM"
            )
        )
        eventList.add(
            EventModel(
                11,
                "CODE_LAB",
                "https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F225022999%2F246938648658%2F1%2Foriginal.20220206-210558?w=512&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C58%2C700%2C350&s=2171bc73e6dbe2779c8ea4bb83bdcc43",
                "Introduction to computer programming for beginners (focus on website dev)",
                -7.967614, 112.632174,
                "Sat, Jun 25, 2022",
                "8:00 PM"
            )
        )

    }

    fun getEventData(): List<EventModel> {
        populateData()
        return eventList
    }


}