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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R

val poppin = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile() {
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
                            text = "Ubah Kata Sandi",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppin
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
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kata sandi baru minimal harus lebih dari 8 karakter.",
                modifier = Modifier
                    .padding(start = 30.dp, top = 40.dp, end = 55.dp, bottom = 40.dp)
                    .widthIn(max = 800.dp),
                fontSize = 12.sp,
                color = Color.Black,
                fontFamily = poppin,
                fontWeight = FontWeight.SemiBold
            )

            PasswordField(
                label = "Kata Sandi Lama",
                value = oldPassword,
                onValueChange = { oldPassword = it }
            )

            PasswordField(
                label = "Kata Sandi Baru",
                value = newPassword,
                onValueChange = { newPassword = it }
            )

            PasswordField(
                label = "Konfirmasi Kata Sandi Baru",
                value = confirmPassword,
                onValueChange = { confirmPassword = it }
            )

            // Tombol Kirim Kode Verifikasi
            Box(
                modifier = Modifier
                    .padding(56.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 272.dp, height = 50.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(10.dp),
                            clip = false
                        )
                        .align(Alignment.BottomCenter)
                )

                Button(
                    onClick = { /* Action untuk update kata sandi */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    ),
                    modifier = Modifier
                        .size(width = 272.dp, height = 50.dp)
                        .background(Color.Transparent, shape = RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    Text(
                        "Kirim Kode Verifikasi",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }

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
            placeholder = { Text(label, color = Color.Black) },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisibility = !passwordVisibility },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    val icon = if (passwordVisibility) {
                        painterResource(id = R.drawable.visibility_off)
                    } else {
                        painterResource(id = R.drawable.visibility)
                    }
                    Image(
                        painter = icon,
                        contentDescription = if (passwordVisibility) "Hide password" else "Show password",
                        modifier = Modifier.size(22.dp, 17.dp)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}
