package edu.daletb.articulodecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.daletb.articulodecompose.ui.theme.ArtículoDeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtículoDeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticuloCompose()
                }
            }
        }
    }
}
@Composable
fun ArticuloCompose(){
    TarjetaArticulo(
        titulo = stringResource(R.string.titulo_tutorial),
        descripcion_corta = stringResource(R.string.texto_descripcion_corta),
        descripcion_completa = stringResource(R.string.texto_descripcion_completa),
        img = painterResource(R.drawable.bg_compose_background)
    )
}
@Composable
fun TarjetaArticulo(
    titulo: String,
    descripcion_corta: String,
    descripcion_completa: String,
    img: Painter,
    modifier: Modifier = Modifier,
) {
    Column(modifier = Modifier) {
        Image(painter = img, contentDescription = null)
        Text(
            text = titulo,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = descripcion_corta,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = descripcion_completa,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticuloComposePrevista(){

    ArtículoDeComposeTheme {
        ArticuloCompose()
    }
}