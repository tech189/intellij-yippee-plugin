Converted from mpeg wav to pcm wav with `ffmpeg -i input.wav -f wav -acodec pcm_s16le output.wav`

Then converted to *.au with `ffmpeg -i input.wav -ac 2 output.au` for compatibility reasons.
