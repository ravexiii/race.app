package com.champions.formula.leaders.race.app.api.models

class DriversResponse {

}
/* Drivers
Provides information about drivers for each session.

curl "https://api.openf1.org/v1/drivers?driver_number=1&session_key=9158"
Output:

[
  {
    "broadcast_name": "M VERSTAPPEN",
    "country_code": "NED",
    "driver_number": 1,
    "first_name": "Max",
    "full_name": "Max VERSTAPPEN",
    "headshot_url": "https://www.formula1.com/content/dam/fom-website/drivers/M/MAXVER01_Max_Verstappen/maxver01.png.transform/1col/image.png",
    "last_name": "Verstappen",
    "meeting_key": 1219,
    "name_acronym": "VER",
    "session_key": 9158,
    "team_colour": "3671C6",
    "team_name": "Red Bull Racing"
  }
]
HTTP Request
GET https://api.openf1.org/v1/drivers

Sample URL
https://api.openf1.org/v1/drivers?driver_number=1&session_key=9158
* */