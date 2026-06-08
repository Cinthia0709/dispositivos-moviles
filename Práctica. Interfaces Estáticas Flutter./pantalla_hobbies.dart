import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Mis Hobbies"),
        backgroundColor: Colors.black,
      ),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          children: const [

            Row(
              children: [
                Icon(Icons.pool),
                SizedBox(width: 10),
                Text("Nadar"),
              ],
            ),

            SizedBox(height: 20),

            Row(
              children: [
                Icon(Icons.language),
                SizedBox(width: 10),
                Text("Practicar idiomas"),
              ],
            ),

            SizedBox(height: 20),

            Row(
              children: [
                Icon(Icons.flight),
                SizedBox(width: 10),
                Text("Viajar"),
              ],
            ),

            SizedBox(height: 20),

            Row(
              children: [
                Icon(Icons.brush),
                SizedBox(width: 10),
                Text("Pintar"),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
