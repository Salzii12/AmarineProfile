import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile() {
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }

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
                            text = "Edit Profil",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
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
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFFFB16D), shape = RoundedCornerShape(30.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto_sementara),
                    contentDescription = "Foto Profil",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(30.dp))
                )
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(Color(0xFFFFB16D), shape = CircleShape)
                        .align(Alignment.BottomEnd)
                        .clickable(onClick = { /* Tambahkan aksi yang diinginkan di sini */ }),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_kamera),
                        contentDescription = "Verified",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Pak Bahrul",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFonts,
                color = Color.Black,
            )

            InputField2(
                label = "Bahrul Widodo Siburian",
                value = fullName,
                onValueChange = { fullName = it }
            )

            InputField(
                label = "082257801234",
                value = phoneNumber,
                onValueChange = { phoneNumber = it }
            )

            InputField(
                label = "Bahrulrimex@gmail.com",
                value = email,
                onValueChange = { email = it }
            )

            GenderButton(
                label = "Laki-Laki",
                selectedGender = gender,
                onGenderSelected = { gender = it }
            )

            InputFieldWithIcon(
                label = "17-08-1945",
                value = birthDate,
                onValueChange = { birthDate = it },
                iconResId = R.drawable.ic_calendar,
                onIconClick = { /* Action ketika ikon ditekan */ }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Action untuk menyimpan perubahan */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3)
                ),
                modifier = Modifier
                    .size(width = 272.dp, height = 50.dp)
                    .shadow(8.dp, shape = RoundedCornerShape(size = 10.dp)),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                Text(
                    "Simpan Perubahan",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            ),
            placeholder = {
                Text(label, color = Color.Black, fontFamily = poppinsFonts)
            },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 12.sp,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFieldWithIcon(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    iconResId: Int,
    onIconClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .width(300.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            ),
            placeholder = {
                Text(label, color = Color.Black, fontFamily = poppinsFonts, fontWeight = FontWeight.Medium) // Menggunakan Medium
            },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 12.sp,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium
            )
        )

        // Tombol Kalender
        Box(
            modifier = Modifier
                .size(55.dp)
                .clickable(onClick = onIconClick)
                .padding(end = 10.dp)
                .background(Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = "Ikon Kalender",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField2(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 60.dp, bottom = 8.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            ),
            placeholder = {
                Text(label, color = Color.Black, fontFamily = poppinsFonts)
            },
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 12.sp,
                fontFamily = poppinsFonts,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun GenderButton(
    label: String,
    selectedGender: String,
    onGenderSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(10.dp),
                clip = false
            )
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .clickable { expanded = !expanded }
    ) {
        Text(
            text = if (selectedGender.isEmpty()) label else selectedGender,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 18.dp),
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppinsFonts
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        "Laki-Laki",
                        fontSize = 12.sp, // Sesuaikan ukuran font
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFonts,
                        color = Color.Black // Sesuaikan warna teks
                    )
                },
                onClick = {
                    onGenderSelected("Laki-Laki")
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        "Perempuan",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFonts,
                        color = Color.Black
                    )
                },
                onClick = {
                    onGenderSelected("Perempuan")
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditProfile()
}
