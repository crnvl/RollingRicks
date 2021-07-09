ffmpeg\bin\ffmpeg.exe -i processing/input.mp4 -ss 00:00:00 -to 00:00:02 -f mov processing/input.mov
ffmpeg\bin\ffmpeg.exe -i processing/sourcevideo.mp4 -ss 00:00:00 -to 00:00:10 -f mov processing/sourcevideo.mov
ffmpeg\bin\ffmpeg.exe -f concat -i processing/mylist.txt -c copy processing/out.mp4
exit