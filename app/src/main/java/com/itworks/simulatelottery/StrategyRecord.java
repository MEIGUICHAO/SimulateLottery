package com.itworks.simulatelottery;

/**
 * Created by mgc on 2017/8/22.
 */

public class StrategyRecord {


    /*
    * 5-35
    * blank 1
    * <100
    * */
//    09-04 17:27:55.347 7338-7628/com.itworks.simulatelottery E/end: end: earn+++urlIndex:7-TODAY_AMOUNT:4914-ALI_LESS_AMOUNT:-4814-LOST_MOST_TODAY:-706-AMOUNT_CURRENT:4914-BIGGEST_AMOUNT:8863-20170628-BIGGEST_TERM:2017-06-28 20:02:46
//            09-04 17:31:40.645 7338-7628/com.itworks.simulatelottery E/end: end: earn+++urlIndex:6-TODAY_AMOUNT:13202-ALI_LESS_AMOUNT:-4212-LOST_MOST_TODAY:-2157-AMOUNT_CURRENT:18116-BIGGEST_AMOUNT:13542-20170629-BIGGEST_TERM:2017-06-29 23:32:46
//            09-04 17:35:26.167 7338-7628/com.itworks.simulatelottery E/end: end: earn+++urlIndex:5-TODAY_AMOUNT:8788-ALI_LESS_AMOUNT:-4800-LOST_MOST_TODAY:-1693-AMOUNT_CURRENT:26904-BIGGEST_AMOUNT:9308-20170630-BIGGEST_TERM:2017-06-30 23:48:06
//            09-04 17:39:10.932 7338-7628/com.itworks.simulatelottery E/end: end: earn+++urlIndex:4-TODAY_AMOUNT:13062-ALI_LESS_AMOUNT:-6756-LOST_MOST_TODAY:-1549-AMOUNT_CURRENT:39966-BIGGEST_AMOUNT:13382-20170701-BIGGEST_TERM:2017-07-01 23:53:00
//            09-04 17:43:56.831 7338-7628/com.itworks.simulatelottery E/end: end: earn+++urlIndex:3-TODAY_AMOUNT:5710-ALI_LESS_AMOUNT:-5343-LOST_MOST_TODAY:-4211-AMOUNT_CURRENT:45676-BIGGEST_AMOUNT:6390-20170702-BIGGEST_TERM:2017-07-02 23:38:05
//            09-04 17:47:42.309 7338-7628/com.itworks.simulatelottery E/end: end: earn+++urlIndex:2-TODAY_AMOUNT:1278-ALI_LESS_AMOUNT:-5092-LOST_MOST_TODAY:-3060-AMOUNT_CURRENT:46954-BIGGEST_AMOUNT:6630-20170703-BIGGEST_TERM:2017-07-03 21:27:51


//            09-04 06:41:29.250 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:59-TODAY_AMOUNT:11261-ALI_LESS_AMOUNT:-5149-LOST_MOST_TODAY:-5149-AMOUNT_CURRENT:11261-BIGGEST_AMOUNT:11751-20170602-BIGGEST_TERM:2017-06-02 23:47:49
//            09-04 06:45:28.661 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:58-TODAY_AMOUNT:-2360-ALI_LESS_AMOUNT:-7938-LOST_MOST_TODAY:-3177-AMOUNT_CURRENT:8901-BIGGEST_AMOUNT:5259-20170603-BIGGEST_TERM:2017-06-03 18:07:54
//            09-04 06:49:28.846 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:57-TODAY_AMOUNT:5509-ALI_LESS_AMOUNT:-9112-LOST_MOST_TODAY:-8735-AMOUNT_CURRENT:14410-BIGGEST_AMOUNT:9258-20170604-BIGGEST_TERM:2017-06-04 21:07:53
//            09-04 06:53:23.431 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:56-TODAY_AMOUNT:-10893-ALI_LESS_AMOUNT:-13241-LOST_MOST_TODAY:-10893-AMOUNT_CURRENT:3517-BIGGEST_AMOUNT:2398-20170605-BIGGEST_TERM:2017-06-05 11:57:55
//            09-04 06:57:14.374 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:55-TODAY_AMOUNT:-1120-ALI_LESS_AMOUNT:-12628-LOST_MOST_TODAY:-6577-AMOUNT_CURRENT:2397-BIGGEST_AMOUNT:6051-20170606-BIGGEST_TERM:2017-06-06 16:13:03
//            09-04 07:01:06.166 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:54-TODAY_AMOUNT:-469-ALI_LESS_AMOUNT:-9131-LOST_MOST_TODAY:-4896-AMOUNT_CURRENT:1928-BIGGEST_AMOUNT:4235-20170607-BIGGEST_TERM:2017-06-07 13:12:44
//            09-04 07:04:56.829 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:53-TODAY_AMOUNT:14768-ALI_LESS_AMOUNT:-3968-LOST_MOST_TODAY:-2493-AMOUNT_CURRENT:16696-BIGGEST_AMOUNT:14948-20170608-BIGGEST_TERM:2017-06-08 23:47:47
//            09-04 07:08:47.625 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:52-TODAY_AMOUNT:6019-ALI_LESS_AMOUNT:-8452-LOST_MOST_TODAY:-8452-AMOUNT_CURRENT:22715-BIGGEST_AMOUNT:6299-20170609-BIGGEST_TERM:2017-06-09 23:57:47
//            09-04 07:09:32.541 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:51-TODAY_AMOUNT:9770-ALI_LESS_AMOUNT:-2305-LOST_MOST_TODAY:-1167-AMOUNT_CURRENT:32485-BIGGEST_AMOUNT:10050-201706010-BIGGEST_TERM:2017-06-09 23:57:47
//            09-04 07:10:16.980 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:50-TODAY_AMOUNT:1966-ALI_LESS_AMOUNT:-5176-LOST_MOST_TODAY:-2152-AMOUNT_CURRENT:34451-BIGGEST_AMOUNT:5882-20170611-BIGGEST_TERM:2017-06-11 20:02:58
//            09-04 07:14:08.028 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:49-TODAY_AMOUNT:-2423-ALI_LESS_AMOUNT:-8147-LOST_MOST_TODAY:-4672-AMOUNT_CURRENT:32028-BIGGEST_AMOUNT:3635-20170612-BIGGEST_TERM:2017-06-12 11:47:52
//            09-04 07:17:59.457 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:48-TODAY_AMOUNT:7362-ALI_LESS_AMOUNT:-6137-LOST_MOST_TODAY:-5664-AMOUNT_CURRENT:39390-BIGGEST_AMOUNT:10793-20170613-BIGGEST_TERM:2017-06-13 21:37:49
//            09-04 07:21:51.094 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:47-TODAY_AMOUNT:1684-ALI_LESS_AMOUNT:-6066-LOST_MOST_TODAY:-5199-AMOUNT_CURRENT:41074-BIGGEST_AMOUNT:2466-20170614-BIGGEST_TERM:2017-06-14 23:22:46
//            09-04 07:25:52.313 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:46-TODAY_AMOUNT:-11271-ALI_LESS_AMOUNT:-19812-LOST_MOST_TODAY:-17378-AMOUNT_CURRENT:29803-BIGGEST_AMOUNT:2514-20170615-BIGGEST_TERM:2017-06-15 10:02:54
//            09-04 07:29:44.031 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:45-TODAY_AMOUNT:-3600-ALI_LESS_AMOUNT:-9593-LOST_MOST_TODAY:-7599-AMOUNT_CURRENT:26203-BIGGEST_AMOUNT:2642-20170616-BIGGEST_TERM:2017-06-16 21:22:46
//            09-04 07:33:36.177 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:44-TODAY_AMOUNT:5230-ALI_LESS_AMOUNT:-6679-LOST_MOST_TODAY:-4071-AMOUNT_CURRENT:31433-BIGGEST_AMOUNT:8083-20170617-BIGGEST_TERM:2017-06-17 21:08:12
//            09-04 07:37:29.542 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:43-TODAY_AMOUNT:-6581-ALI_LESS_AMOUNT:-12787-LOST_MOST_TODAY:-12787-AMOUNT_CURRENT:24852-BIGGEST_AMOUNT:0-20170618-BIGGEST_TERM:2017-06-17 21:08:12
//            09-04 07:41:22.317 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:42-TODAY_AMOUNT:-995-ALI_LESS_AMOUNT:-10308-LOST_MOST_TODAY:-5679-AMOUNT_CURRENT:23857-BIGGEST_AMOUNT:4859-20170619-BIGGEST_TERM:2017-06-19 17:07:50
//            09-04 07:45:16.178 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:41-TODAY_AMOUNT:6872-ALI_LESS_AMOUNT:-4653-LOST_MOST_TODAY:-1300-AMOUNT_CURRENT:30729-BIGGEST_AMOUNT:10456-20170620-BIGGEST_TERM:2017-06-20 21:42:51
//            09-04 07:49:08.875 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:40-TODAY_AMOUNT:-8365-ALI_LESS_AMOUNT:-10121-LOST_MOST_TODAY:-10121-AMOUNT_CURRENT:22364-BIGGEST_AMOUNT:0-20170621-BIGGEST_TERM:2017-06-20 21:42:51
//            09-04 07:53:02.797 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:39-TODAY_AMOUNT:7253-ALI_LESS_AMOUNT:-4805-LOST_MOST_TODAY:-3971-AMOUNT_CURRENT:29617-BIGGEST_AMOUNT:7903-20170622-BIGGEST_TERM:2017-06-22 23:52:45
//            09-04 07:56:56.207 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:38-TODAY_AMOUNT:-14138-ALI_LESS_AMOUNT:-19877-LOST_MOST_TODAY:-19294-AMOUNT_CURRENT:15479-BIGGEST_AMOUNT:1023-20170623-BIGGEST_TERM:2017-06-23 12:12:56
//            09-04 08:00:49.369 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:37-TODAY_AMOUNT:6878-ALI_LESS_AMOUNT:-3217-LOST_MOST_TODAY:-3217-AMOUNT_CURRENT:22357-BIGGEST_AMOUNT:9771-20170624-BIGGEST_TERM:2017-06-24 22:57:52
//            09-04 08:04:43.662 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:36-TODAY_AMOUNT:372-ALI_LESS_AMOUNT:-5854-LOST_MOST_TODAY:-2076-AMOUNT_CURRENT:22729-BIGGEST_AMOUNT:3994-20170625-BIGGEST_TERM:2017-06-25 14:38:37
//            09-04 08:08:38.815 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:35-TODAY_AMOUNT:2706-ALI_LESS_AMOUNT:-8124-LOST_MOST_TODAY:-3888-AMOUNT_CURRENT:25435-BIGGEST_AMOUNT:4366-20170626-BIGGEST_TERM:2017-06-26 11:23:07
//            09-04 08:12:39.695 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:34-TODAY_AMOUNT:-5390-ALI_LESS_AMOUNT:-13217-LOST_MOST_TODAY:-10313-AMOUNT_CURRENT:20045-BIGGEST_AMOUNT:2904-20170627-BIGGEST_TERM:2017-06-27 13:47:49
//            09-04 08:16:36.280 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:33-TODAY_AMOUNT:6498-ALI_LESS_AMOUNT:-4814-LOST_MOST_TODAY:-470-AMOUNT_CURRENT:26543-BIGGEST_AMOUNT:10447-20170628-BIGGEST_TERM:2017-06-28 20:02:46
//            09-04 08:20:32.453 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:32-TODAY_AMOUNT:13202-ALI_LESS_AMOUNT:-4212-LOST_MOST_TODAY:-2157-AMOUNT_CURRENT:39745-BIGGEST_AMOUNT:13542-20170629-BIGGEST_TERM:2017-06-29 23:32:46
//            09-04 08:24:29.503 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:31-TODAY_AMOUNT:8788-ALI_LESS_AMOUNT:-4800-LOST_MOST_TODAY:-1693-AMOUNT_CURRENT:48533-BIGGEST_AMOUNT:9308-20170630-BIGGEST_TERM:2017-06-30 23:48:06
//            09-04 08:28:27.517 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:30-TODAY_AMOUNT:13062-ALI_LESS_AMOUNT:-6756-LOST_MOST_TODAY:-1549-AMOUNT_CURRENT:61595-BIGGEST_AMOUNT:13382-20170701-BIGGEST_TERM:2017-07-01 23:53:00
//            09-04 08:32:24.706 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:29-TODAY_AMOUNT:5710-ALI_LESS_AMOUNT:-5343-LOST_MOST_TODAY:-4211-AMOUNT_CURRENT:67305-BIGGEST_AMOUNT:6390-20170702-BIGGEST_TERM:2017-07-02 23:38:05
//            09-04 08:36:24.779 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:28-TODAY_AMOUNT:1278-ALI_LESS_AMOUNT:-5092-LOST_MOST_TODAY:-3060-AMOUNT_CURRENT:68583-BIGGEST_AMOUNT:6630-20170703-BIGGEST_TERM:2017-07-03 21:27:51
//            09-04 08:40:22.357 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:27-TODAY_AMOUNT:-8273-ALI_LESS_AMOUNT:-12704-LOST_MOST_TODAY:-12704-AMOUNT_CURRENT:60310-BIGGEST_AMOUNT:0-20170704-BIGGEST_TERM:2017-07-03 21:27:51
//            09-04 08:44:19.320 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:26-TODAY_AMOUNT:7327-ALI_LESS_AMOUNT:-6424-LOST_MOST_TODAY:-5153-AMOUNT_CURRENT:67637-BIGGEST_AMOUNT:10225-20170705-BIGGEST_TERM:2017-07-05 21:22:36
//            09-04 08:48:15.732 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:25-TODAY_AMOUNT:2092-ALI_LESS_AMOUNT:-5269-LOST_MOST_TODAY:-3624-AMOUNT_CURRENT:69729-BIGGEST_AMOUNT:3500-20170706-BIGGEST_TERM:2017-07-06 23:17:39
//            09-04 08:52:12.548 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:24-TODAY_AMOUNT:1764-ALI_LESS_AMOUNT:-8717-LOST_MOST_TODAY:-1500-AMOUNT_CURRENT:71493-BIGGEST_AMOUNT:10035-20170707-BIGGEST_TERM:2017-07-07 20:07:38
//            09-04 08:56:10.614 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:23-TODAY_AMOUNT:3850-ALI_LESS_AMOUNT:-6610-LOST_MOST_TODAY:-1220-AMOUNT_CURRENT:75343-BIGGEST_AMOUNT:6422-20170708-BIGGEST_TERM:2017-07-08 14:12:49
//            09-04 09:00:08.132 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:22-TODAY_AMOUNT:-6563-ALI_LESS_AMOUNT:-9249-LOST_MOST_TODAY:-8222-AMOUNT_CURRENT:68780-BIGGEST_AMOUNT:1107-20170709-BIGGEST_TERM:2017-07-09 09:07:44
//            09-04 09:04:06.656 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:21-TODAY_AMOUNT:7991-ALI_LESS_AMOUNT:-8068-LOST_MOST_TODAY:-3204-AMOUNT_CURRENT:76771-BIGGEST_AMOUNT:8661-20170710-BIGGEST_TERM:2017-07-10 23:52:38
//            09-04 09:08:06.652 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:20-TODAY_AMOUNT:6058-ALI_LESS_AMOUNT:-7889-LOST_MOST_TODAY:-4135-AMOUNT_CURRENT:82829-BIGGEST_AMOUNT:7178-20170711-BIGGEST_TERM:2017-07-11 23:27:44
//            09-04 09:12:05.872 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:19-TODAY_AMOUNT:-2938-ALI_LESS_AMOUNT:-7619-LOST_MOST_TODAY:-6826-AMOUNT_CURRENT:79891-BIGGEST_AMOUNT:1255-20170712-BIGGEST_TERM:2017-07-12 22:22:49
//            09-04 09:16:05.023 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:18-TODAY_AMOUNT:-3189-ALI_LESS_AMOUNT:-9215-LOST_MOST_TODAY:-6271-AMOUNT_CURRENT:76702-BIGGEST_AMOUNT:3184-20170713-BIGGEST_TERM:2017-07-13 19:33:02
//            09-04 09:20:03.835 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:17-TODAY_AMOUNT:8634-ALI_LESS_AMOUNT:-5035-LOST_MOST_TODAY:-5035-AMOUNT_CURRENT:85336-BIGGEST_AMOUNT:12072-20170714-BIGGEST_TERM:2017-07-14 22:48:12
//            09-04 09:24:02.229 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:16-TODAY_AMOUNT:5391-ALI_LESS_AMOUNT:-6300-LOST_MOST_TODAY:-6300-AMOUNT_CURRENT:90727-BIGGEST_AMOUNT:5781-20170715-BIGGEST_TERM:2017-07-15 23:48:26
//            09-04 09:28:02.183 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:15-TODAY_AMOUNT:-8832-ALI_LESS_AMOUNT:-11010-LOST_MOST_TODAY:-10146-AMOUNT_CURRENT:81895-BIGGEST_AMOUNT:1074-20170716-BIGGEST_TERM:2017-07-16 09:43:00
//            09-04 09:32:04.703 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:14-TODAY_AMOUNT:-5093-ALI_LESS_AMOUNT:-12213-LOST_MOST_TODAY:-9027-AMOUNT_CURRENT:76802-BIGGEST_AMOUNT:3446-20170717-BIGGEST_TERM:2017-07-17 11:13:01
//            09-04 09:36:04.750 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:13-TODAY_AMOUNT:9064-ALI_LESS_AMOUNT:-3005-LOST_MOST_TODAY:-626-AMOUNT_CURRENT:85866-BIGGEST_AMOUNT:9554-20170718-BIGGEST_TERM:2017-07-18 23:42:58
//            09-04 09:40:05.343 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:12-TODAY_AMOUNT:-5409-ALI_LESS_AMOUNT:-9910-LOST_MOST_TODAY:-7539-AMOUNT_CURRENT:80457-BIGGEST_AMOUNT:2551-20170719-BIGGEST_TERM:2017-07-19 17:58:25
//            09-04 09:44:05.303 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:11-TODAY_AMOUNT:3626-ALI_LESS_AMOUNT:-4366-LOST_MOST_TODAY:-1611-AMOUNT_CURRENT:84083-BIGGEST_AMOUNT:6309-20170720-BIGGEST_TERM:2017-07-20 23:03:09
//            09-04 09:48:05.854 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:10-TODAY_AMOUNT:-5695-ALI_LESS_AMOUNT:-12589-LOST_MOST_TODAY:-12589-AMOUNT_CURRENT:78388-BIGGEST_AMOUNT:0-20170721-BIGGEST_TERM:2017-07-20 23:03:09
//            09-04 09:52:06.541 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:9-TODAY_AMOUNT:-1741-ALI_LESS_AMOUNT:-4996-LOST_MOST_TODAY:-2333-AMOUNT_CURRENT:76647-BIGGEST_AMOUNT:2969-20170722-BIGGEST_TERM:2017-07-22 18:58:17
//            09-04 09:56:07.584 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:8-TODAY_AMOUNT:17395-ALI_LESS_AMOUNT:-4711-LOST_MOST_TODAY:-730-AMOUNT_CURRENT:94042-BIGGEST_AMOUNT:22206-20170723-BIGGEST_TERM:2017-07-23 22:53:32
//            09-04 10:00:08.248 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:7-TODAY_AMOUNT:-6080-ALI_LESS_AMOUNT:-14271-LOST_MOST_TODAY:-14271-AMOUNT_CURRENT:87962-BIGGEST_AMOUNT:0-20170724-BIGGEST_TERM:2017-07-23 22:53:32
//            09-04 10:04:09.500 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:6-TODAY_AMOUNT:-6714-ALI_LESS_AMOUNT:-13066-LOST_MOST_TODAY:-7968-AMOUNT_CURRENT:81248-BIGGEST_AMOUNT:5118-20170725-BIGGEST_TERM:2017-07-25 13:53:21
//            09-04 10:08:11.842 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:5-TODAY_AMOUNT:4210-ALI_LESS_AMOUNT:-9520-LOST_MOST_TODAY:-7579-AMOUNT_CURRENT:85458-BIGGEST_AMOUNT:5687-20170726-BIGGEST_TERM:2017-07-26 22:28:00
//            09-04 10:12:12.147 1888-1936/com.itworks.simulatelottery E/end: end: lost---urlIndex:4-TODAY_AMOUNT:-3701-ALI_LESS_AMOUNT:-9680-LOST_MOST_TODAY:-8653-AMOUNT_CURRENT:81757-BIGGEST_AMOUNT:1177-20170727-BIGGEST_TERM:2017-07-27 14:12:46
//            09-04 10:16:19.366 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:3-TODAY_AMOUNT:818-ALI_LESS_AMOUNT:-7705-LOST_MOST_TODAY:-1146-AMOUNT_CURRENT:82575-BIGGEST_AMOUNT:6559-20170728-BIGGEST_TERM:2017-07-28 17:27:46
//            09-04 10:20:23.858 1888-1936/com.itworks.simulatelottery E/end: end: earn+++urlIndex:2-TODAY_AMOUNT:2802-ALI_LESS_AMOUNT:-7733-LOST_MOST_TODAY:-5573-AMOUNT_CURRENT:85377-BIGGEST_AMOUNT:3130-20170729-BIGGEST_TERM:2017-07-29 23:37:39


    /*
    * change amount
    * */
//            09-04 18:12:17.071 1905-2446/com.itworks.simulatelottery E/end: end: earn+++urlIndex:7-TODAY_AMOUNT:5528-ALI_LESS_AMOUNT:-1877-LOST_MOST_TODAY:-1877-AMOUNT_CURRENT:5528-BIGGEST_AMOUNT:5955-20170628-BIGGEST_TERM:2017-06-28 22:33:05
//            09-04 18:16:20.181 1905-2446/com.itworks.simulatelottery E/end: end: earn+++urlIndex:6-TODAY_AMOUNT:3773-ALI_LESS_AMOUNT:-4008-LOST_MOST_TODAY:-1724-AMOUNT_CURRENT:9301-BIGGEST_AMOUNT:6024-20170629-BIGGEST_TERM:2017-06-29 18:17:53
//            09-04 18:20:29.753 1905-2446/com.itworks.simulatelottery E/end: end: earn+++urlIndex:5-TODAY_AMOUNT:6309-ALI_LESS_AMOUNT:-2931-LOST_MOST_TODAY:-712-AMOUNT_CURRENT:15610-BIGGEST_AMOUNT:6399-20170630-BIGGEST_TERM:2017-06-30 23:48:06
//            09-04 18:24:33.066 1905-2446/com.itworks.simulatelottery E/end: end: earn+++urlIndex:4-TODAY_AMOUNT:5468-ALI_LESS_AMOUNT:-4575-LOST_MOST_TODAY:-2238-AMOUNT_CURRENT:21078-BIGGEST_AMOUNT:5758-20170701-BIGGEST_TERM:2017-07-01 23:53:00
//            09-04 18:28:36.128 1905-2446/com.itworks.simulatelottery E/end: end: earn+++urlIndex:3-TODAY_AMOUNT:1127-ALI_LESS_AMOUNT:-2833-LOST_MOST_TODAY:-1902-AMOUNT_CURRENT:22205-BIGGEST_AMOUNT:1467-20170702-BIGGEST_TERM:2017-07-02 23:38:05
//            09-04 18:32:22.026 1905-2446/com.itworks.simulatelottery E/end: end: lost---urlIndex:2-TODAY_AMOUNT:-2616-ALI_LESS_AMOUNT:-5171-LOST_MOST_TODAY:-4555-AMOUNT_CURRENT:19589-BIGGEST_AMOUNT:616-20170703-BIGGEST_TERM:2017-07-03 09:47:55


    /*
    * changed
    * */
//    09-04 18:41:10.950 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:59-TODAY_AMOUNT:8446-ALI_LESS_AMOUNT:-1323-LOST_MOST_TODAY:-1323-AMOUNT_CURRENT:8446-BIGGEST_AMOUNT:8656-20170602-BIGGEST_TERM:2017-06-02 23:47:49
//            09-04 18:45:00.549 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:58-TODAY_AMOUNT:804-ALI_LESS_AMOUNT:-3887-LOST_MOST_TODAY:-1440-AMOUNT_CURRENT:9250-BIGGEST_AMOUNT:2557-20170603-BIGGEST_TERM:2017-06-03 19:07:51
//            09-04 18:48:51.801 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:57-TODAY_AMOUNT:-2144-ALI_LESS_AMOUNT:-4830-LOST_MOST_TODAY:-4830-AMOUNT_CURRENT:7106-BIGGEST_AMOUNT:157-20170604-BIGGEST_TERM:2017-06-04 09:07:51
//            09-04 18:52:38.420 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:56-TODAY_AMOUNT:-1174-ALI_LESS_AMOUNT:-3569-LOST_MOST_TODAY:-1174-AMOUNT_CURRENT:5932-BIGGEST_AMOUNT:2435-20170605-BIGGEST_TERM:2017-06-05 12:37:49
//            09-04 18:56:22.423 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:55-TODAY_AMOUNT:-474-ALI_LESS_AMOUNT:-6930-LOST_MOST_TODAY:-3042-AMOUNT_CURRENT:5458-BIGGEST_AMOUNT:3958-20170606-BIGGEST_TERM:2017-06-06 16:58:01
//            09-04 19:00:04.908 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:54-TODAY_AMOUNT:-1850-ALI_LESS_AMOUNT:-5345-LOST_MOST_TODAY:-3813-AMOUNT_CURRENT:3608-BIGGEST_AMOUNT:1532-20170607-BIGGEST_TERM:2017-06-07 13:12:44
//            09-04 19:03:49.476 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:53-TODAY_AMOUNT:4066-ALI_LESS_AMOUNT:-3417-LOST_MOST_TODAY:-795-AMOUNT_CURRENT:7674-BIGGEST_AMOUNT:4389-20170608-BIGGEST_TERM:2017-06-08 23:27:49
//            09-04 19:07:29.499 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:52-TODAY_AMOUNT:2990-ALI_LESS_AMOUNT:-3183-LOST_MOST_TODAY:-3183-AMOUNT_CURRENT:10664-BIGGEST_AMOUNT:3060-20170609-BIGGEST_TERM:2017-06-09 23:57:47
//            09-04 19:08:12.120 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:51-TODAY_AMOUNT:3933-ALI_LESS_AMOUNT:-815-LOST_MOST_TODAY:-284-AMOUNT_CURRENT:14597-BIGGEST_AMOUNT:4003-201706010-BIGGEST_TERM:2017-06-09 23:57:47
//            09-04 19:08:55.049 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:50-TODAY_AMOUNT:-937-ALI_LESS_AMOUNT:-3965-LOST_MOST_TODAY:-2069-AMOUNT_CURRENT:13660-BIGGEST_AMOUNT:2115-20170611-BIGGEST_TERM:2017-06-11 20:02:58
//            09-04 19:12:40.868 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:49-TODAY_AMOUNT:-1182-ALI_LESS_AMOUNT:-5346-LOST_MOST_TODAY:-4118-AMOUNT_CURRENT:12478-BIGGEST_AMOUNT:1435-20170612-BIGGEST_TERM:2017-06-12 11:47:52
//            09-04 19:16:24.385 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:48-TODAY_AMOUNT:1827-ALI_LESS_AMOUNT:-4471-LOST_MOST_TODAY:-4471-AMOUNT_CURRENT:14305-BIGGEST_AMOUNT:4247-20170613-BIGGEST_TERM:2017-06-13 21:37:49
//            09-04 19:20:06.540 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:47-TODAY_AMOUNT:584-ALI_LESS_AMOUNT:-3348-LOST_MOST_TODAY:-3348-AMOUNT_CURRENT:14889-BIGGEST_AMOUNT:794-20170614-BIGGEST_TERM:2017-06-14 23:32:55
//            09-04 19:23:50.382 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:46-TODAY_AMOUNT:-5627-ALI_LESS_AMOUNT:-9838-LOST_MOST_TODAY:-8477-AMOUNT_CURRENT:9262-BIGGEST_AMOUNT:1381-20170615-BIGGEST_TERM:2017-06-15 10:02:54
//            09-04 19:27:38.632 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:45-TODAY_AMOUNT:-3804-ALI_LESS_AMOUNT:-5413-LOST_MOST_TODAY:-3804-AMOUNT_CURRENT:5458-BIGGEST_AMOUNT:1657-20170616-BIGGEST_TERM:2017-06-16 10:02:45
//            09-04 19:31:22.163 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:44-TODAY_AMOUNT:7780-ALI_LESS_AMOUNT:-2960-LOST_MOST_TODAY:-254-AMOUNT_CURRENT:13238-BIGGEST_AMOUNT:7970-20170617-BIGGEST_TERM:2017-06-17 23:47:58
//            09-04 19:35:08.394 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:43-TODAY_AMOUNT:1772-ALI_LESS_AMOUNT:-5132-LOST_MOST_TODAY:-4630-AMOUNT_CURRENT:15010-BIGGEST_AMOUNT:1932-20170618-BIGGEST_TERM:2017-06-18 23:52:52
//            09-04 19:38:52.682 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:42-TODAY_AMOUNT:3531-ALI_LESS_AMOUNT:-2980-LOST_MOST_TODAY:-956-AMOUNT_CURRENT:18541-BIGGEST_AMOUNT:4976-20170619-BIGGEST_TERM:2017-06-19 17:07:50
//            09-04 19:42:36.932 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:41-TODAY_AMOUNT:402-ALI_LESS_AMOUNT:-2766-LOST_MOST_TODAY:-775-AMOUNT_CURRENT:18943-BIGGEST_AMOUNT:2500-20170620-BIGGEST_TERM:2017-06-20 13:32:53
//            09-04 19:46:21.094 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:40-TODAY_AMOUNT:-8411-ALI_LESS_AMOUNT:-8411-LOST_MOST_TODAY:-8411-AMOUNT_CURRENT:10532-BIGGEST_AMOUNT:84-20170621-BIGGEST_TERM:2017-06-21 10:42:42
//            09-04 19:50:04.671 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:39-TODAY_AMOUNT:162-ALI_LESS_AMOUNT:-4114-LOST_MOST_TODAY:-3047-AMOUNT_CURRENT:10694-BIGGEST_AMOUNT:1097-20170622-BIGGEST_TERM:2017-06-22 14:58:15
//            09-04 19:53:49.826 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:38-TODAY_AMOUNT:-7579-ALI_LESS_AMOUNT:-10419-LOST_MOST_TODAY:-9961-AMOUNT_CURRENT:3115-BIGGEST_AMOUNT:536-20170623-BIGGEST_TERM:2017-06-23 12:12:56
//            09-04 19:57:34.785 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:37-TODAY_AMOUNT:781-ALI_LESS_AMOUNT:-2434-LOST_MOST_TODAY:-1662-AMOUNT_CURRENT:3896-BIGGEST_AMOUNT:1374-20170624-BIGGEST_TERM:2017-06-24 22:57:52
//            09-04 20:01:20.338 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:36-TODAY_AMOUNT:4295-ALI_LESS_AMOUNT:-2163-LOST_MOST_TODAY:-660-AMOUNT_CURRENT:8191-BIGGEST_AMOUNT:4395-20170625-BIGGEST_TERM:2017-06-25 23:52:57
//            09-04 20:05:04.389 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:35-TODAY_AMOUNT:2614-ALI_LESS_AMOUNT:-3423-LOST_MOST_TODAY:-1246-AMOUNT_CURRENT:10805-BIGGEST_AMOUNT:3689-20170626-BIGGEST_TERM:2017-06-26 22:52:42
//            09-04 20:08:52.398 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:34-TODAY_AMOUNT:-791-ALI_LESS_AMOUNT:-6579-LOST_MOST_TODAY:-4559-AMOUNT_CURRENT:10014-BIGGEST_AMOUNT:2234-20170627-BIGGEST_TERM:2017-06-27 13:47:49
//            09-04 20:12:42.570 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:33-TODAY_AMOUNT:6532-ALI_LESS_AMOUNT:-1867-LOST_MOST_TODAY:-873-AMOUNT_CURRENT:16546-BIGGEST_AMOUNT:6959-20170628-BIGGEST_TERM:2017-06-28 22:33:05
//            09-04 20:16:29.712 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:32-TODAY_AMOUNT:3773-ALI_LESS_AMOUNT:-4008-LOST_MOST_TODAY:-1724-AMOUNT_CURRENT:20319-BIGGEST_AMOUNT:6024-20170629-BIGGEST_TERM:2017-06-29 18:17:53
//            09-04 20:20:16.667 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:31-TODAY_AMOUNT:6309-ALI_LESS_AMOUNT:-2931-LOST_MOST_TODAY:-712-AMOUNT_CURRENT:26628-BIGGEST_AMOUNT:6399-20170630-BIGGEST_TERM:2017-06-30 23:48:06
//            09-04 20:24:04.221 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:30-TODAY_AMOUNT:5468-ALI_LESS_AMOUNT:-4575-LOST_MOST_TODAY:-2238-AMOUNT_CURRENT:32096-BIGGEST_AMOUNT:5758-20170701-BIGGEST_TERM:2017-07-01 23:53:00
//            09-04 20:27:51.893 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:29-TODAY_AMOUNT:1127-ALI_LESS_AMOUNT:-2833-LOST_MOST_TODAY:-1902-AMOUNT_CURRENT:33223-BIGGEST_AMOUNT:1467-20170702-BIGGEST_TERM:2017-07-02 23:38:05
//            09-04 20:31:38.893 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:28-TODAY_AMOUNT:-2616-ALI_LESS_AMOUNT:-5171-LOST_MOST_TODAY:-4555-AMOUNT_CURRENT:30607-BIGGEST_AMOUNT:616-20170703-BIGGEST_TERM:2017-07-03 09:47:55
//            09-04 20:35:26.384 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:27-TODAY_AMOUNT:-6637-ALI_LESS_AMOUNT:-9354-LOST_MOST_TODAY:-9354-AMOUNT_CURRENT:23970-BIGGEST_AMOUNT:0-20170704-BIGGEST_TERM:2017-07-03 09:47:55
//            09-04 20:39:14.739 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:26-TODAY_AMOUNT:4800-ALI_LESS_AMOUNT:-3057-LOST_MOST_TODAY:-2290-AMOUNT_CURRENT:28770-BIGGEST_AMOUNT:5826-20170705-BIGGEST_TERM:2017-07-05 21:22:36
//            09-04 20:43:02.609 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:25-TODAY_AMOUNT:-753-ALI_LESS_AMOUNT:-3616-LOST_MOST_TODAY:-3616-AMOUNT_CURRENT:28017-BIGGEST_AMOUNT:182-20170706-BIGGEST_TERM:2017-07-06 09:22:41
//            09-04 20:46:50.545 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:24-TODAY_AMOUNT:2435-ALI_LESS_AMOUNT:-4612-LOST_MOST_TODAY:-581-AMOUNT_CURRENT:30452-BIGGEST_AMOUNT:5558-20170707-BIGGEST_TERM:2017-07-07 20:07:38
//            09-04 20:50:38.968 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:23-TODAY_AMOUNT:1920-ALI_LESS_AMOUNT:-4347-LOST_MOST_TODAY:-703-AMOUNT_CURRENT:32372-BIGGEST_AMOUNT:3772-20170708-BIGGEST_TERM:2017-07-08 14:12:49
//            09-04 20:54:28.599 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:22-TODAY_AMOUNT:-2322-ALI_LESS_AMOUNT:-2852-LOST_MOST_TODAY:-2507-AMOUNT_CURRENT:30050-BIGGEST_AMOUNT:562-20170709-BIGGEST_TERM:2017-07-09 19:12:45
//            09-04 20:58:17.695 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:21-TODAY_AMOUNT:6285-ALI_LESS_AMOUNT:-2825-LOST_MOST_TODAY:-730-AMOUNT_CURRENT:36335-BIGGEST_AMOUNT:6628-20170710-BIGGEST_TERM:2017-07-10 21:27:40
//            09-04 21:02:06.551 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:20-TODAY_AMOUNT:7634-ALI_LESS_AMOUNT:-2228-LOST_MOST_TODAY:-1415-AMOUNT_CURRENT:43969-BIGGEST_AMOUNT:7904-20170711-BIGGEST_TERM:2017-07-11 23:27:44
//            09-04 21:05:56.403 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:19-TODAY_AMOUNT:-5446-ALI_LESS_AMOUNT:-6609-LOST_MOST_TODAY:-6609-AMOUNT_CURRENT:38523-BIGGEST_AMOUNT:42-20170712-BIGGEST_TERM:2017-07-12 09:32:46
//            09-04 21:09:46.004 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:18-TODAY_AMOUNT:-3215-ALI_LESS_AMOUNT:-5615-LOST_MOST_TODAY:-5615-AMOUNT_CURRENT:35308-BIGGEST_AMOUNT:0-20170713-BIGGEST_TERM:2017-07-12 09:32:46
//            09-04 21:13:35.789 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:17-TODAY_AMOUNT:1469-ALI_LESS_AMOUNT:-3630-LOST_MOST_TODAY:-3630-AMOUNT_CURRENT:36777-BIGGEST_AMOUNT:2269-20170714-BIGGEST_TERM:2017-07-14 23:42:53
//            09-04 21:17:26.127 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:16-TODAY_AMOUNT:-969-ALI_LESS_AMOUNT:-5700-LOST_MOST_TODAY:-5700-AMOUNT_CURRENT:35808-BIGGEST_AMOUNT:0-20170715-BIGGEST_TERM:2017-07-14 23:42:53
//            09-04 21:21:15.780 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:15-TODAY_AMOUNT:27-ALI_LESS_AMOUNT:-3321-LOST_MOST_TODAY:-2754-AMOUNT_CURRENT:35835-BIGGEST_AMOUNT:2115-20170716-BIGGEST_TERM:2017-07-16 22:37:57
//            09-04 21:25:06.533 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:14-TODAY_AMOUNT:-3635-ALI_LESS_AMOUNT:-5905-LOST_MOST_TODAY:-5157-AMOUNT_CURRENT:32200-BIGGEST_AMOUNT:768-20170717-BIGGEST_TERM:2017-07-17 10:08:21
//            09-04 21:28:57.705 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:13-TODAY_AMOUNT:4487-ALI_LESS_AMOUNT:-2444-LOST_MOST_TODAY:-290-AMOUNT_CURRENT:36687-BIGGEST_AMOUNT:5087-20170718-BIGGEST_TERM:2017-07-18 20:43:06
//            09-04 21:32:48.373 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:12-TODAY_AMOUNT:-2722-ALI_LESS_AMOUNT:-6164-LOST_MOST_TODAY:-3732-AMOUNT_CURRENT:33965-BIGGEST_AMOUNT:2631-20170719-BIGGEST_TERM:2017-07-19 17:08:42
//            09-04 21:36:39.194 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:11-TODAY_AMOUNT:2004-ALI_LESS_AMOUNT:-3593-LOST_MOST_TODAY:-790-AMOUNT_CURRENT:35969-BIGGEST_AMOUNT:4963-20170720-BIGGEST_TERM:2017-07-20 18:08:12
//            09-04 21:40:30.029 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:10-TODAY_AMOUNT:-9835-ALI_LESS_AMOUNT:-10200-LOST_MOST_TODAY:-10200-AMOUNT_CURRENT:26134-BIGGEST_AMOUNT:0-20170721-BIGGEST_TERM:2017-07-20 18:08:12
//            09-04 21:44:21.564 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:9-TODAY_AMOUNT:-4496-ALI_LESS_AMOUNT:-4496-LOST_MOST_TODAY:-4496-AMOUNT_CURRENT:21638-BIGGEST_AMOUNT:105-20170722-BIGGEST_TERM:2017-07-22 09:22:54
//            09-04 21:48:15.308 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:8-TODAY_AMOUNT:2646-ALI_LESS_AMOUNT:-3353-LOST_MOST_TODAY:-361-AMOUNT_CURRENT:24284-BIGGEST_AMOUNT:5368-20170723-BIGGEST_TERM:2017-07-23 22:53:32
//            09-04 21:52:07.925 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:7-TODAY_AMOUNT:-152-ALI_LESS_AMOUNT:-3792-LOST_MOST_TODAY:-3113-AMOUNT_CURRENT:24132-BIGGEST_AMOUNT:699-20170724-BIGGEST_TERM:2017-07-24 09:52:54
//            09-04 21:56:00.927 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:6-TODAY_AMOUNT:-6064-ALI_LESS_AMOUNT:-8679-LOST_MOST_TODAY:-6132-AMOUNT_CURRENT:18068-BIGGEST_AMOUNT:2734-20170725-BIGGEST_TERM:2017-07-25 13:53:21
//            09-04 21:59:53.662 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:5-TODAY_AMOUNT:2520-ALI_LESS_AMOUNT:-3866-LOST_MOST_TODAY:-2829-AMOUNT_CURRENT:20588-BIGGEST_AMOUNT:4296-20170726-BIGGEST_TERM:2017-07-26 22:28:00
//            09-04 22:03:46.610 27695-28164/com.itworks.simulatelottery E/end: end: lost---urlIndex:4-TODAY_AMOUNT:-3321-ALI_LESS_AMOUNT:-6352-LOST_MOST_TODAY:-5956-AMOUNT_CURRENT:17267-BIGGEST_AMOUNT:434-20170727-BIGGEST_TERM:2017-07-27 14:12:46
//            09-04 22:07:39.772 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:3-TODAY_AMOUNT:2862-ALI_LESS_AMOUNT:-3621-LOST_MOST_TODAY:-580-AMOUNT_CURRENT:20129-BIGGEST_AMOUNT:3890-20170728-BIGGEST_TERM:2017-07-28 19:22:43
//            09-04 22:11:32.358 27695-28164/com.itworks.simulatelottery E/end: end: earn+++urlIndex:2-TODAY_AMOUNT:1027-ALI_LESS_AMOUNT:-7365-LOST_MOST_TODAY:-4945-AMOUNT_CURRENT:21156-BIGGEST_AMOUNT:2692-20170729-BIGGEST_TERM:2017-07-29 12:02:42


//    09-05 11:45:15.718 11846-12338/com.itworks.simulatelottery E/end: end: earn+++urlIndex:59-TODAY_AMOUNT:1481-ALI_LESS_AMOUNT:-1478-LOST_MOST_TODAY:-1478-AMOUNT_CURRENT:1481-BIGGEST_AMOUNT:1711-20170602-BIGGEST_TERM:2017-06-02 23:47:49


/*
* 10-40
* biggerint1
* danger10
* */
//09-05 11:54:32.614 20091-20487/com.itworks.simulatelottery E/end: end: earn+++urlIndex:7-TODAY_AMOUNT:786-ALI_LESS_AMOUNT:-337-LOST_MOST_TODAY:-337-AMOUNT_CURRENT:786-BIGGEST_AMOUNT:866-20170629-BIGGEST_TERM:2017-06-29 21:47:56
//            09-05 11:58:29.638 20091-20487/com.itworks.simulatelottery E/end: end: earn+++urlIndex:6-TODAY_AMOUNT:555-ALI_LESS_AMOUNT:-420-LOST_MOST_TODAY:-74-AMOUNT_CURRENT:1341-BIGGEST_AMOUNT:555-20170630-BIGGEST_TERM:2017-06-30 21:12:42
//            09-05 12:02:21.287 20091-20487/com.itworks.simulatelottery E/end: end: earn+++urlIndex:5-TODAY_AMOUNT:588-ALI_LESS_AMOUNT:-570-LOST_MOST_TODAY:-460-AMOUNT_CURRENT:1929-BIGGEST_AMOUNT:791-20170701-BIGGEST_TERM:2017-07-01 23:17:54
//            09-05 12:06:11.805 20091-20487/com.itworks.simulatelottery E/end: end: earn+++urlIndex:4-TODAY_AMOUNT:301-ALI_LESS_AMOUNT:-700-LOST_MOST_TODAY:-700-AMOUNT_CURRENT:2230-BIGGEST_AMOUNT:301-20170702-BIGGEST_TERM:2017-07-02 17:23:19


//09-05 04:03:23.449 9723-9991/com.itworks.simulatelottery E/end: end: earn+++urlIndex:57-TODAY_AMOUNT:2357-ALI_LESS_AMOUNT:-1635-LOST_MOST_TODAY:-1635-AMOUNT_CURRENT:2357-BIGGEST_AMOUNT:2859-20170604-BIGGEST_TERM:2017-06-04 22:22:45
//            09-05 04:07:08.221 9723-9991/com.itworks.simulatelottery E/end: end: earn+++urlIndex:56-TODAY_AMOUNT:304-ALI_LESS_AMOUNT:-3271-LOST_MOST_TODAY:-1655-AMOUNT_CURRENT:2661-BIGGEST_AMOUNT:1616-20170605-BIGGEST_TERM:2017-06-05 11:18:26
//            09-05 04:10:54.886 9723-9991/com.itworks.simulatelottery E/end: end: lost---urlIndex:55-TODAY_AMOUNT:-1144-ALI_LESS_AMOUNT:-3888-LOST_MOST_TODAY:-2134-AMOUNT_CURRENT:1517-BIGGEST_AMOUNT:1966-20170606-BIGGEST_TERM:2017-06-06 18:33:20


//09-05 04:53:17.870 23750-24062/com.itworks.simulatelottery E/end: end: lost---urlIndex:16-TODAY_AMOUNT:-2604-ALI_LESS_AMOUNT:-3444-LOST_MOST_TODAY:-3444-AMOUNT_CURRENT:11373-BIGGEST_AMOUNT:209-20170715-BIGGEST_TERM:2017-07-15 11:22:56
//            09-05 04:57:14.631 23750-24062/com.itworks.simulatelottery E/end: end: lost---urlIndex:15-TODAY_AMOUNT:-1127-ALI_LESS_AMOUNT:-2910-LOST_MOST_TODAY:-2910-AMOUNT_CURRENT:10246-BIGGEST_AMOUNT:217-20170716-BIGGEST_TERM:2017-07-16 12:28:17
//            09-05 05:01:07.520 23750-24062/com.itworks.simulatelottery E/end: end: lost---urlIndex:14-TODAY_AMOUNT:-2554-ALI_LESS_AMOUNT:-4869-LOST_MOST_TODAY:-4869-AMOUNT_CURRENT:7692-BIGGEST_AMOUNT:222-20170717-BIGGEST_TERM:2017-07-17 11:38:06

//    09-05 05:09:09.904 23750-24062/com.itworks.simulatelottery E/end: end: earn+++urlIndex:12-TODAY_AMOUNT:2240-ALI_LESS_AMOUNT:-2878-LOST_MOST_TODAY:-1628-AMOUNT_CURRENT:11383-BIGGEST_AMOUNT:2240-20170719-BIGGEST_TERM:2017-07-19 23:08:10
//            09-05 05:13:05.610 23750-24062/com.itworks.simulatelottery E/end: end: earn+++urlIndex:11-TODAY_AMOUNT:826-ALI_LESS_AMOUNT:-360-LOST_MOST_TODAY:-360-AMOUNT_CURRENT:12209-BIGGEST_AMOUNT:1006-20170720-BIGGEST_TERM:2017-07-20 21:48:05
//            09-05 05:17:06.243 23750-24062/com.itworks.simulatelottery E/end: end: lost---urlIndex:10-TODAY_AMOUNT:-2544-ALI_LESS_AMOUNT:-5015-LOST_MOST_TODAY:-5015-AMOUNT_CURRENT:9665-BIGGEST_AMOUNT:192-20170721-BIGGEST_TERM:2017-07-21 09:22:52
//            09-05 05:21:16.925 23750-24062/com.itworks.simulatelottery E/end: end: earn+++urlIndex:9-TODAY_AMOUNT:1279-ALI_LESS_AMOUNT:-1572-LOST_MOST_TODAY:-1291-AMOUNT_CURRENT:10944-BIGGEST_AMOUNT:1399-20170722-BIGGEST_TERM:2017-07-22 23:53:03
//            09-05 05:25:24.348 23750-24062/com.itworks.simulatelottery E/end: end: earn+++urlIndex:8-TODAY_AMOUNT:1211-ALI_LESS_AMOUNT:-1140-LOST_MOST_TODAY:-530-AMOUNT_CURRENT:12155-BIGGEST_AMOUNT:2501-20170723-BIGGEST_TERM:2017-07-23 23:42:57
//    09-05 05:29:32.568 23750-24062/com.itworks.simulatelottery E/end: end: lost---urlIndex:7-TODAY_AMOUNT:-1961-ALI_LESS_AMOUNT:-5282-LOST_MOST_TODAY:-5282-AMOUNT_CURRENT:10194-BIGGEST_AMOUNT:0-20170724-BIGGEST_TERM:2017-07-23 23:42:57

    /*
    * 1-60
    * 4
    * danger10
    * */

}