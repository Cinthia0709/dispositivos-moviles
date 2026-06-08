import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mi Perfil"),
        backgroundColor: Colors.green,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          children: [

            Image.network(
              "https://picsum.photos/200",
              height: 180,
            ),

            const SizedBox(height: 20),

            const Text(
              "Cinthia Blanco",
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),

            const SizedBox(height: 10),

            const Text(
              "Estudiante de Ingeniería de Sistemas. Me gustan los viajes, los idiomas y conocer nuevas culturas.",
              textAlign: TextAlign.center,
            ),

            const SizedBox(height: 20),

            const Row(
              children: [
                Icon(Icons.email),
                SizedBox(width: 10),
                Text("cinthia@email.com"),
              ],
            ),

            const SizedBox(height: 10),

            const Row(
              children: [
                Icon(Icons.phone),
                SizedBox(width: 10),
                Text("999 999 999"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
