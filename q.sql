select * from public.show ;


select * from public.show where title like 'Avtaar2';

select * from public.screen_show where show_id = '826b0dd1-9f71-4063-920f-24256ee7965d' ;

select * from public.screen_show where show_id = (select show_id from public.show where title like 'Avtaar2');

select * from public.theater where theater_id = '6571a436-5a80-42dd-8ea9-2be0ab90650b';

select * from public.screen where theater_id = '6571a436-5a80-42dd-8ea9-2be0ab90650b';

select * from public.screen  where  screen_id = '6ba75181-7e92-4d4a-8df3-47fe79d62d90';

select * from public.theater where theater_id = (select theater_id from public.screen  where  screen_id = '6ba75181-7e92-4d4a-8df3-47fe79d62d90');


select * from public.theater where theater_id in (
	select theater_id from public.screen  where  screen_id  in (
		select screen_id from public.screen_show where show_id in (
			select show_id from public.show where title like '%')));
			

select ss.*, show.* from public.screen_show as ss
		inner join show on show.show_id = ss.show_id;

select ss.*, show.* from public.screen_show as ss
		inner join show on show.show_id = ss.show_id where show.title like 'Titanic'
		
select ss.*, show.*, s.*, t.* from public.screen_show ss
		inner join show on show.show_id = ss.show_id 
		inner join screen s on s.screen_id = ss.screen_id
		inner join theater t on t.theater_id = s.theater_id ;	
		
		
select ss.*, sh.*, sc.*, t.* from public.screen_show ss
		inner join show sh on sh.show_id = ss.show_id 
		inner join screen sc on sc.screen_id = ss.screen_id
		inner join theater t on t.theater_id = sc.theater_id 
		where sh.title like 'Titanic';			
		
select ss.*, sh.*, sc.*, t.* from public.screen_show ss
		inner join show sh on sh.show_id = ss.show_id 
		inner join screen sc on sc.screen_id = ss.screen_id
		inner join theater t on t.theater_id = sc.theater_id 
-- 		where t.name not like 'PVR' 
-- -- 		and sc.name like 'PVR2' 
-- -- 		and ss.show_date_time > NOW()
-- 		and ss.show_date_time > NOW() 
-- -- 		and sh.genere = 4;	

select ss.*, sh.*, sc.*, t.* from public.screen_show ss
		inner join show sh on sh.show_id = ss.show_id 
		inner join screen sc on sc.screen_id = ss.screen_id
		inner join theater t on t.theater_id = sc.theater_id 
		
		
select ss.*, sh.*, sc.*, t.*,b.*, u.* from public.screen_show ss
		inner join show sh on sh.show_id = ss.show_id 
		inner join screen sc on sc.screen_id = ss.screen_id
		inner join theater t on t.theater_id = sc.theater_id 
		inner join booking b on b.screen_show_id = ss.screen_show_id
		inner join user_entity u on u.id = b.user_id
		
						
-- Queries for the submission
select ss.*, sh.*, sc.*, t.* from public.screen_show ss
		inner join show sh on sh.show_id = ss.show_id 
		inner join screen sc on sc.screen_id = ss.screen_id
		inner join theater t on t.theater_id = sc.theater_id 
		where ss.show_date_time > NOW() 
		and t.zip = '111111'
		and sh.title like 'Avtaar2'
		and ss.show_date_time >= '2023-01-20'::date
		AND ss.show_date_time < ('2023-01-20'::date + '1 day'::interval);