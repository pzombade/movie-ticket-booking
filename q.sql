select * from public.show ;


select * from public.show where title like 'Avtaar2';

select * from public.screen_show where show_id = '826b0dd1-9f71-4063-920f-24256ee7965d' ;

select * from public.screen_show where show_id = (select show_id from public.show where title like 'Avtaar2');

select * from public.theater where theater_id = '6571a436-5a80-42dd-8ea9-2be0ab90650b';

select * from public.screen where theater_id = '6571a436-5a80-42dd-8ea9-2be0ab90650b';

select * from public.screen  where  screen_id = '6ba75181-7e92-4d4a-8df3-47fe79d62d90';

select * from public.theater where theater_id = (select theater_id from public.screen  where  screen_id = '6ba75181-7e92-4d4a-8df3-47fe79d62d90');