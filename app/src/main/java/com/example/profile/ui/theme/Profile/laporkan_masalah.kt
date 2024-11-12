import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R

val poppinsFonts1 = FontFamily(
    Font(R.font.poppins_regular), // pastikan sesuai dengan nama file di folder font
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaporkanMasalah() {
    var verifiedCode by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Kembali",
                            modifier = Modifier
                                .clickable(onClick = { /* Halaman kembali jika ditekan */ })
                                .size(30.dp)
                                .padding(start = 5.dp)
                        )
                        Text(
                            text = "Laporkan Masalah",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFonts1
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFF620A),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
            ) {
                // Shadow effect for the bottom side
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .align(Alignment.BottomCenter)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(10.dp), // Shape sesuai dengan container
                            clip = false
                        )
                )

                // Kolom textfield
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(start = 20.dp, end = 20.dp)
                        .size(width = 367.dp, height = 121.dp)
                        .clickable(onClick = { /* Tindakan yang diinginkan saat area ini diklik */ }) // Menambahkan clickable
                ) {
                    TextField(
                        value = verifiedCode,
                        onValueChange = { verifiedCode = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = {
                            Text(
                                text = "Apa Yang Bisa Kami Bantu?",
                                fontSize = 16.sp,
                                color = Color.Black, // Mengubah warna placeholder menjadi hitam
                                fontFamily = poppinsFonts1,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(start = 0.dp)
                            )
                        }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Kami akan merespon anda melalui email",
                    modifier = Modifier.padding(top = 15.dp, start = 35.dp),
                    fontSize = 11.sp,
                    color = Color.Black,
                    fontFamily = poppinsFonts1,
                    fontWeight = FontWeight.Medium
                )

                // Tombol Kirim
                Box(
                    modifier = Modifier
                        .padding(top = 28.dp, start = 228.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(10.dp),
                                clip = false
                            )
                            .align(Alignment.BottomCenter)
                    )
                    Button(
                        onClick = { /* Action untuk kirim laporan */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        ),
                        modifier = Modifier
                            .width(141.dp)
                            .height(50.dp)
                            .padding(bottom = 4.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            "Kirim",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LaporkanMasalahPreview() {
    LaporkanMasalah()
}
